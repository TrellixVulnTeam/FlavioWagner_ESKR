import { Pessoa } from './../../../model/pessoa';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detalheperfil',
  templateUrl: './detalhe.perfil.component.html',
  styleUrls: ['./detalhe.perfil.component.scss']
})
export class DetalhePerfilComponent implements OnInit {

  pessoa:Pessoa;

  constructor() { }

  ngOnInit(): void {

  }
}
