export enum MessagemClass {
  Success = 'success',
  Info = 'info',
  Warning = 'warning',
  Error = 'error',
  Custom = 'custom'
}

export class Mensagem{
  severity:MessagemClass
  summary:String;
  detail:String;

  constructor(severity:MessagemClass,summary:String,detail:String){
    this.severity = severity;
    this.summary = summary;
    this.detail = detail;
  }
}
