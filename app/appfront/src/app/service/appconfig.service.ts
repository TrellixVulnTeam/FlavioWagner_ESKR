import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { AppConfig } from '../model/appconfig';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  config: AppConfig = {
    theme: 'lara-light-indigo',
    dark: false,
    inputStyle: 'outlined',
    ripple: true
  };

  private configUpdate = new Subject<AppConfig>();

  configUpdate$ = this.configUpdate.asObservable();

  apiUrl: String = environment.urlAPI;

  constructor(private http: HttpClient) { }

  updateConfig(config: AppConfig) {
    this.config = config;
    this.configUpdate.next(config);
  }

  getConfig() {
    return this.config;
  }

  GetTheme(): Observable<AppConfig> {
    const url = this.apiUrl + 'appconfig/1';
    return this.http.get<AppConfig>(url);
  }

  SalvarTema(conf: AppConfig): boolean {
    let retorno: AppConfig;
    try {
      if (conf.id == null) {
        console.log('1');
        this.http.post(`${this.apiUrl}appconfig`, conf)
          .subscribe(
            resultado => {
              retorno = resultado;
            }
          );
      } else {
        this.http.put<AppConfig>(`${this.apiUrl}appconfig`, conf)
          .subscribe(
            resultado => {
              retorno = resultado
            }
          );
      }
      return true;
    } catch (error) {
      console.log(error)
      return false;
    }
  }
}
