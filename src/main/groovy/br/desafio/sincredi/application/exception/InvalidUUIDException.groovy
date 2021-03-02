package br.desafio.sincredi.application.exception

import groovy.transform.CompileStatic

@CompileStatic
class InvalidUUIDException extends SincrediException {

   final String uuid

   InvalidUUIDException(String uuid, Throwable cause) {
      super(cause)
      this.uuid = uuid
   }

   InvalidUUIDException(String uuid) {
      this.uuid = uuid
   }

   @Override
   String getMessage() {
      "A chave informada ('${this.uuid}') Não possui um valor válido."
   }

}
