package br.desafio.sincredi.application.resource.controller.rest

import br.desafio.sincredi.application.exception.SincrediException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class RestResponseEntityExceptionHandler {

   @ExceptionHandler(value = [HttpMessageNotReadableException.class])
   @ResponseStatus(value = HttpStatus.BAD_REQUEST)
   ResponseEntity<Object> handleMessageNotReadableException() {
      ResponseEntity.badRequest().body('This should be application specific')
   }

   @ExceptionHandler(value = [SincrediException.class])
   @ResponseStatus(value = HttpStatus.BAD_REQUEST)
   ResponseEntity<Object> handleSincrediException(Exception e) {
      ResponseEntity.badRequest().body("Erro ao processar requisição: ${e.message}")
   }

}
