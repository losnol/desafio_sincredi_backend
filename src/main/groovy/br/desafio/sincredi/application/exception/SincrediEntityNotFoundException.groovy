package br.desafio.sincredi.application.exception

import groovy.transform.CompileStatic

@CompileStatic
class SincrediEntityNotFoundException extends SincrediException {

   final String entity
   final String id

   SincrediEntityNotFoundException(String entity, String id) {
      this.entity = entity
      this.id = id
   }

   SincrediEntityNotFoundException(Throwable cause, String entity, String id) {
      super(cause)
      this.entity = entity
      this.id = id
   }

   @Override
   String getMessage() {
      "'${this.entity}' com identificador ${this.id} não encontrado(a)"
   }

}
