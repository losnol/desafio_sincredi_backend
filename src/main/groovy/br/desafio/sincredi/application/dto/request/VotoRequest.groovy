package br.desafio.sincredi.application.dto.request

import br.desafio.sincredi.application.utils.enums.VotoEnum
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class VotoRequest {

   String cpf
   String idPauta
   VotoEnum voto

}
