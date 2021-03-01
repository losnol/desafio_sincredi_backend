package br.desafio.sincredi.application.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class CreateAssociadoRequest {

   @JsonProperty(required = true)
   String cpf

   @JsonProperty(required = true)
   String nome

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
   @JsonProperty(required = true)
   LocalDate dataNascimento

}
