package br.desafio.sincredi.application.exception

import groovy.transform.CompileStatic

@CompileStatic
class SessaoFechadaException extends SincrediException {

   final String id

   SessaoFechadaException(String id, Throwable cause) {
      super(cause)
      this.id = id
   }

   SessaoFechadaException(String id) {
      this.id = id
   }

   @Override
   String getMessage(){
      "A sessão '${this.id}' não pode receber votos, pois não está aberta."
   }

}
