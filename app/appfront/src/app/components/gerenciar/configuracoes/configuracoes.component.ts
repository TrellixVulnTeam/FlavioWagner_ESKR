import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { Estado } from 'src/app/model/estado';
import { EstadoService } from 'src/app/service/estado.service';


@Component({
    selector: 'app-configuracoes',
    templateUrl: './configuracoes.component.html',
    styles: [`:host ::ng-deep .p-multiselect {
  min-width: 15rem;
}

:host ::ng-deep .multiselect-custom-virtual-scroll .p-multiselect {
  min-width: 20rem;
}

:host ::ng-deep .multiselect-custom .p-multiselect-label,  {
  padding-top: 0.75rem;
  padding-bottom: 0.75rem;

}

:host ::ng-deep .multiselect-custom .country-item.country-item-value {
  padding: .25rem .5rem;
  border-radius: 3px;
  display: inline-flex;
  margin-right: .5rem;
  background-color: var(--primary-color);
  color: var(--primary-color-text);
}

:host ::ng-deep .multiselect-custom .country-item.country-item-value img.flag {
  width: 17px;
}

:host ::ng-deep .multiselect-custom .country-item {
  display: flex;
  align-items: center;
}

:host ::ng-deep .multiselect-custom .country-item img.flag {
  width: 18px;
  margin-right: .5rem;
}

:host ::ng-deep .multiselect-custom .country-placeholder {
  padding: 0.25rem;
}

  `]
})
export class ConfiguracoesComponent implements OnInit {
 
    estados: Estado[] = [];

    estadosItem: SelectItem[] = [];

    filteredestados: Estado[];

    itemSelected: SelectItem;

    constructor(private service: EstadoService) { }

    ngOnInit() {
        this.listarEstados();
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
        this.service.Listar().subscribe(resposta => {
            this.estados = resposta;
            resposta.forEach(estado => {
                this.estadosItem.push({ label: estado.nome, value: estado.uf });
            })
        });
    }   
}
