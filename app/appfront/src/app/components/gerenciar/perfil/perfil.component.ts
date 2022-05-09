import { DetalhePerfilComponent } from './detalhe.perfil.component';
import { EstadoService } from 'src/app/service/estado.service';
import { Estado } from 'src/app/model/estado';
import { map } from 'rxjs/operators';
import { Pessoa } from './../../../model/pessoa';
import { Component, OnInit } from '@angular/core';
import { MenuItem, SelectItem } from 'primeng/api';
import { PessoaService } from 'src/app/service/pessoa.service';

@Component({
    selector: 'app-perfil',
    templateUrl: './perfil.component.html',
    styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

    items: MenuItem[];
    cardMenu: MenuItem[];

    pessoas:Pessoa[]=[];
    estados: Estado[] = [];
    estadosItem: SelectItem[] = [];
    filteredestados: Estado[];
    itemSelected: SelectItem;



    constructor(private pessoaService: PessoaService,
                private estadoService: EstadoService) { }

    ngOnInit() {
      /*
        this.items = [
            { label: 'Angular.io', icon: 'pi pi-external-link', url: 'http://angular.io' },
            { label: 'Theming', icon: 'pi pi-bookmark', routerLink: ['/theming'] }
        ];

        this.cardMenu = [
            {
                label: 'Save', icon: 'pi pi-fw pi-check'
            },
            {
                label: 'Update', icon: 'pi pi-fw pi-refresh'
            },
            {
                label: 'Delete', icon: 'pi pi-fw pi-trash'
            },
        ];
        */

        this.ListarPessoas();
        this.listarEstados();
    }

    ListarPessoas():void{
      this.pessoaService.Listar().subscribe(x=>{this.pessoas = x});
    }

    filterEstado(event: any) {
      const filtered: any[] = [];
      const query = event.query;
      for (let i = 0; i < this.estados.length; i++) {
          const estado = this.estados[i];
          if (estado.nome.toLowerCase().indexOf(query.toLowerCase()) == 0) {
              filtered.push(estado);
          }
      }

      this.filteredestados = filtered;
  }

  listarEstados() {
      this.estadoService.Listar().subscribe(resposta => {
          this.estados = resposta;
          resposta.forEach(estado => {
              this.estadosItem.push({ label: estado.nome, value: estado.uf });
          })
      });
  }
}
