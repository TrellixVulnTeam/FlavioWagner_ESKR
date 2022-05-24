import { EventEmitter, Injectable } from '@angular/core';

export enum TipoMessagem {
  Success = 'success',
  Info = 'info',
  Warning = 'warn',
  Error = 'error',
  Custom = 'custom'
}

@Injectable({
  providedIn:'root'
})
export class Mensagem{
  public emissor = new EventEmitter();

  constructor(){

  }

  show(summary:String,detail:String,severity:TipoMessagem = TipoMessagem.Success){
    return this.emissor.emit({ key: 'tst', severity: severity, summary: summary, detail: detail });
  }
}
