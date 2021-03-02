package br.desafio.sincredi.application.dto.to

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class DuracaoPautaTO {

   Long segundos
   Long minutos
   Long horas

}
