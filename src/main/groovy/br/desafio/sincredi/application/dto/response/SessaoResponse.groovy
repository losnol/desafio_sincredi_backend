package br.desafio.sincredi.application.dto.response

import br.desafio.sincredi.application.dto.to.DuracaoPautaTO
import br.desafio.sincredi.application.utils.enums.StatusSessao
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class SessaoResponse {

   PautaResponse pauta
   DuracaoPautaTO duracao
   Set<String> votos
   StatusSessao status

}
