import { Observable } from 'rxjs';

export interface ICustom<T,I>{
  Listar():Observable<T[]>;
  Item(id:I):Observable<T>;
  Alterar(item:T):Observable<T>;
  Incluir(item:T):Observable<T>;
  Deletar(id:I):boolean;
}
