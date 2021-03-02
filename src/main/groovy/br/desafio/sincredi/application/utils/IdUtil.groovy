package br.desafio.sincredi.application.utils

import br.desafio.sincredi.application.exception.InvalidUUIDException
import groovy.transform.CompileStatic

@CompileStatic
final class IdUtil {

   private IdUtil() {}

   static UUID uUIDFromString(String id) {
      try {
         return UUID.fromString(id)
      } catch (IllegalArgumentException e) {
         throw new InvalidUUIDException(id, e)
      }
   }

}
