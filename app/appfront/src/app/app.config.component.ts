import { Component, OnDestroy, OnInit } from '@angular/core';
import { PrimeNGConfig, MessageService, Message } from 'primeng/api';
import { Subscription } from 'rxjs';
import { AppConfig } from './model/appconfig';
import { AppComponent } from './app.component';
import { AppMainComponent } from './app.main.component';
import { ConfigService } from './service/appconfig.service';

@Component({
  selector: 'app-config',
  templateUrl: './app.config.component.html',
  styles: [`
		:host ::ng-deep .p-message {
			margin-left: .25em;
		}

        :host ::ng-deep .p-toast{
            margin-top: 5.70em;
            z-index:99999;
        }
    `],
  providers: [MessageService]
})
export class AppConfigComponent implements OnInit, OnDestroy {

  msgs: Message[] = [];

  scale: number = 14;

  scales: any[] = [12, 13, 14, 15, 16];

  config: AppConfig;
  ret: AppConfig;

  subscription: Subscription;

  constructor(public app: AppComponent,
    public appMain: AppMainComponent,
    public configService: ConfigService,
    private service: MessageService,
    public primengConfig: PrimeNGConfig) { }

  ngOnInit() {
    this.config = this.configService.config;
    this.GetThemeSite();
    this.applyTheme();

    console.log(this.config);

    this.subscription = this.configService.configUpdate$.subscribe(config => {
      console.log(config);
      this.config = config;
      this.scale = 14;

      this.applyScale();
    });
  }

  onConfigButtonClick(event) {
    this.appMain.configActive = !this.appMain.configActive;
    this.appMain.configClick = true;
    event.preventDefault();
  }

  incrementScale() {
    this.scale++;
    this.applyScale();
  }

  decrementScale() {
    this.scale--;
    this.applyScale();
  }

  applyScale() {
    document.documentElement.style.fontSize = this.scale + 'px';
  }

  onRippleChange(ripple) {
    this.primengConfig.ripple = ripple;
    this.configService.updateConfig({ ...this.config, ...{ ripple } });
  }

  onInputStyleChange() {
    this.configService.updateConfig(this.config);
  }

  changeTheme(theme: string, dark: boolean) {
    let themeElement = document.getElementById('theme-css');
    themeElement.setAttribute('href', 'assets/theme/' + theme + '/theme.css');
    this.configService.updateConfig({ ...this.config, ...{ theme, dark } });
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  GetThemeSite(): void {
    this.configService.GetTheme().subscribe(resposta => {
      if (resposta.theme != null) {
        this.config = resposta;
        this.applyTheme();
      }
    });

  }

  applyTheme(): void {
    this.changeTheme(this.config.theme, this.config.dark);
  }

  SalvarTemaSite(): void {
    let opcao:boolean = this.configService.SalvarTema(this.config);
    console.log(opcao);

    if (opcao) {
      this.ShowMessage('success', 'Solicitação Processada', 'Tema alterado com sucesso!');
    } else {
      this.ShowMessage('error', 'Solicitação não Processada', 'Tema não foi alterado!');
    }
  };


  ShowMessage(tipoSeverity: String, msgSummary: String, msgDetail: String) {
    let valor: any = { key: 'tst', severity: tipoSeverity, summary: msgSummary, detail: msgDetail };
    this.service.add(valor);
  }
}
