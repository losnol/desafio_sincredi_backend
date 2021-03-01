package br.desafio.sincredi.application.exception

import groovy.transform.CompileStatic

@CompileStatic
class MissingFieldException extends SincrediException {

   final List<String> fields = new ArrayList<>()

   MissingFieldException(String field) {
      this.fields + field
   }

   MissingFieldException(List<String> fields) {
      this.fields + this.fields
   }

   MissingFieldException(String fields, Throwable cause) {
      super(cause)
      this.fields + fields
   }

   @Override
   String getMessage() {
      "Requisição inválida. Campo(s) '${this.fields}' não pode(m) ser nulo(s) ou ausente(s)."
   }

}
