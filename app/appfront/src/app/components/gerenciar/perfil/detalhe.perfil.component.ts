import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { PessoaService } from 'src/app/service/pessoa.service';
import { Pessoa } from './../../../model/pessoa';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detalheperfil',
  templateUrl: './detalhe.perfil.component.html',
  styleUrls: ['./detalhe.perfil.component.scss'],
  providers: [DynamicDialogRef, DynamicDialogConfig]
})
export class DetalhePerfilComponent implements OnInit {

  isSalvo: boolean = false;
  pessoa: Pessoa;

  constructor(private pessoaService: PessoaService,
    public ref: DynamicDialogRef,
    public config: DynamicDialogConfig) { }

  ngOnInit(): void {
    this.CarregarPessoa(1);
  }

  CarregarPessoa(id: number): void {
    this.pessoaService.Item(id).subscribe(resposta => {
      this.pessoa = resposta;
    });
  }
}
