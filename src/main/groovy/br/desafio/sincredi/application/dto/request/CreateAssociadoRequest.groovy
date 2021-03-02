package br.desafio.sincredi.application.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty
=======
>>>>>>> dev
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class CreateAssociadoRequest {

   String cpf
   String nome

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
   LocalDate dataNascimento

}
