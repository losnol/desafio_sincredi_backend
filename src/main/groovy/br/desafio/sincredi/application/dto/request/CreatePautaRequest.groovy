package br.desafio.sincredi.application.dto.request


import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class CreatePautaRequest {

   @JsonProperty(required = true)
   String nomePauta

}
