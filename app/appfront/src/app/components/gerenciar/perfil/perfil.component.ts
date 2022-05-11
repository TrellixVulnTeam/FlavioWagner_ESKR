import { DetalhePerfilComponent } from './detalhe.perfil.component';
import { EstadoService } from 'src/app/service/estado.service';
import { Estado } from 'src/app/model/estado';
import { Pessoa } from './../../../model/pessoa';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { MenuItem, SelectItem, MessageService } from 'primeng/api';
import { PessoaService } from 'src/app/service/pessoa.service';
import { DialogService, DynamicDialogConfig } from 'primeng/dynamicdialog';
import { DynamicDialogRef } from 'primeng/dynamicdialog';


@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {
  items: MenuItem[];
  cardMenu: MenuItem[];

  pessoas: Pessoa[] = [];
  estados: Estado[] = [];
  estadosItem: SelectItem[] = [];
  filteredestados: Estado[];
  itemSelected: SelectItem;


  constructor(private pessoaService: PessoaService,
    private estadoService: EstadoService,
    private dialogService: DialogService) { }

  ngOnInit() {
    this.ListarPessoas();
    this.listarEstados();
  }

  ListarPessoas(): void {
    this.pessoaService.Listar().subscribe(x => { this.pessoas = x });
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

  public openDialog(): void {


    const ref = this.dialogService.open(DetalhePerfilComponent, {
      header: 'Gerenciar',
      contentStyle: {"max-height": "500px", "overflow": "none"},
      data: {
        id: 1
      }
    });

  }
/*
  public closeDialog(): void {
    // We can use the dialog ref to close the dialog
    if (this.dialogRef) {
      this.dialogRef.close();
    }
  }
  */

}
