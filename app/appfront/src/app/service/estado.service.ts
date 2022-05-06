import { Estado } from './../model/estado';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  apiUrl : String = environment.urlAPI;
  constructor(private http: HttpClient) { }

  Listar():Observable<Estado[]>{
    const url =  this.apiUrl + 'estados';
    //console.log(url);
    return this.http.get<Estado[]>(url)
  }
}
