package br.desafio.sincredi.application.exception

import groovy.transform.CompileStatic

@CompileStatic
class SincrediException extends Exception {

   SincrediException(Throwable cause) {
      super(cause)
   }

   SincrediException() {
   }

}
