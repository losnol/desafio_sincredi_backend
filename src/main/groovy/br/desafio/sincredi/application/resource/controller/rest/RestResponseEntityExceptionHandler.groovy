package br.desafio.sincredi.application.resource.controller.rest

import br.desafio.sincredi.application.exception.SincrediException
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class RestResponseEntityExceptionHandler {

   @ExceptionHandler(value = [HttpMessageNotReadableException.class])
   ResponseEntity<Object> handleMessageNotReadableException(Exception e) {
      if (e.cause instanceof MismatchedInputException) {
         def msg = e.cause.message
         int start = msg.indexOf("'") + 1
         int idxEnd = start + 1
         int end = msg.indexOf("'", idxEnd)
         return ResponseEntity.badRequest().body("Erro ao processar requisição: Campo '${msg.substring(start, end)}'" +
               " não presente.")
      }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body('Erro ao processar o conteúdo da ' +
            'mensagem.')
   }

   @ExceptionHandler(value = [SincrediException.class])
   @ResponseStatus(value = HttpStatus.BAD_REQUEST)
   ResponseEntity<Object> handleSincrediException(Exception e) {
      ResponseEntity.badRequest().body("Erro ao processar requisição: \"${e.message}\"")
   }

   @ExceptionHandler(value = [Exception.class])
   @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
   ResponseEntity<Object> handleException(Exception e) {
      ResponseEntity.badRequest().body("Erro ao processar a requisição.\nMensagem Original: \"${e.message}\"")
   }

}
