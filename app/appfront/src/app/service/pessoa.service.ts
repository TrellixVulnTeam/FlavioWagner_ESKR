import { ICustom } from './interfaces/icustom.service';
import { Pessoa } from './../model/pessoa';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PessoaService implements ICustom<Pessoa,number>{

  URLServico : any = environment.urlAPI + "pessoa";

  constructor(private http: HttpClient) { }

  Listar():Observable<Pessoa[]>{
    console.log(this.URLServico);
    return this.http.get<Pessoa[]>(this.URLServico);
  }

  Item(id: number): Observable<Pessoa> {
    const param:any = id;
    throw this.http.get<Pessoa>(this.URLServico,param);
  }

  Alterar(item: Pessoa): Observable<Pessoa> {
    return this.http.get<Pessoa>(this.URLServico);
  }

  Incluir(item: Pessoa): Observable<Pessoa> {
    return this.http.get<Pessoa>(this.URLServico);
  }

  Deletar(id: number): boolean {
    try {
      const param:any = id;
      this.http.delete<Pessoa>(this.URLServico,param)
      return true;
    } catch (error) {
      return false;
    }
  }

}
