package br.desafio.sincredi.application.dto.response

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDate

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class AssociadoResponse {

   String cpf
   String nome
   LocalDate dataNascimento

}
