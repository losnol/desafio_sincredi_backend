package br.desafio.sincredi.application.exception

class SessaoJaAbertaException extends SincrediException {

     final String id

   SessaoJaAbertaException(String id, Throwable cause) {
      super(cause)
      this.id = id
   }

   SessaoJaAbertaException(String id) {
      this.id = id
   }

   @Override
   String getMessage(){
      "A sessão '${this.id}' não pode ser aberta novamente, pois já foi uma vez."
   }

}
