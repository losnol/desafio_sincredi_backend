package br.desafio.sincredi.application.dto.request

import br.desafio.sincredi.application.utils.enums.VotoEnum
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class VotoRequest {

   @JsonProperty(required = true)
   String cpf

   @JsonProperty(required = true)
   String idPauta

   @JsonProperty(required = true)
   VotoEnum voto

}
