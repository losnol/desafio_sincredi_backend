package br.desafio.sincredi.application.utils

import br.desafio.sincredi.application.exception.MissingFieldException
import groovy.transform.CompileStatic

@CompileStatic
final class NullCheckUtil {

   private NullCheckUtil() {}

   static void check(Object... objs) {
      def missing = []
      objs.each {
         if (!it)
            missing + it
      }
      if (missing)
         throw new MissingFieldException(missing)
   }

}
