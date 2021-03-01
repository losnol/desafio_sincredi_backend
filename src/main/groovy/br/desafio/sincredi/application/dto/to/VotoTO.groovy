package br.desafio.sincredi.application.dto.to

import br.desafio.sincredi.application.utils.enums.VotoEnum
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class VotoTO {

   VotoEnum valor
   String cpfAssociado

}
