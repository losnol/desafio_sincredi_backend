package br.desafio.sincredi.application.bo

import br.desafio.sincredi.application.utils.enums.StatusPauta
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includeFields = true, includeNames = true, includePackage = false)
@ToString
class PautaBO {

   String id
   LocalDateTime dataInscricao
   Long duracao
   LocalDateTime inicio
   Boolean aprovada
   StatusPauta status

}
