package br.desafio.sincredi.application.dto.response


import br.desafio.sincredi.application.utils.enums.ResultadoPauta
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode
@ToString(includeFields = true, includeNames = true, includePackage = false)
class PautaResponse {

   String id
   String nomePauta
   LocalDateTime dataInscricao
   ResultadoPauta resultado
   Boolean ativa

}

