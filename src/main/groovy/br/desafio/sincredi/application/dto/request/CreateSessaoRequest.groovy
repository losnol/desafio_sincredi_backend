package br.desafio.sincredi.application.dto.request

import br.desafio.sincredi.application.dto.to.DuracaoPautaTO
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
=======
>>>>>>> dev
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class CreateSessaoRequest {

   DuracaoPautaTO duracao
   String pautaId

<<<<<<< HEAD
   @JsonCreator
   CreateSessaoRequest(@JsonProperty(value = 'pautaId', required = true) String pautaId, @JsonProperty('duracao') DuracaoPautaTO duracao) {
      this.duracao = duracao
      this.pautaId = pautaId
   }

=======
>>>>>>> dev
}
