package br.desafio.sincredi.application.dto.request

import br.desafio.sincredi.application.utils.enums.VotoEnum
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty
=======
>>>>>>> dev
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class VotoRequest {

<<<<<<< HEAD
   @JsonProperty(required = true)
   String cpf

   @JsonProperty(required = true)
   String idPauta

   @JsonProperty(required = true)
=======
   String cpf
   String idPauta
>>>>>>> dev
   VotoEnum voto

}
