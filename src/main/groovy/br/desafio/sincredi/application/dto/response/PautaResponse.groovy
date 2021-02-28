package br.desafio.sincredi.application.dto.response

import br.desafio.sincredi.application.dto.to.DuracaoPautaTO
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class PautaResponse {

   String id
   DuracaoPautaTO duracao
   LocalDateTime dataInscricao

}

