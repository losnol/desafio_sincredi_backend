package br.desafio.sincredi.application.dto.request

import br.desafio.sincredi.application.dto.to.DuracaoPautaTO
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class CreatePautaRequest {

   DuracaoPautaTO duracao

}
