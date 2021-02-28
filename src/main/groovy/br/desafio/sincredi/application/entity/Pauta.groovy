package br.desafio.sincredi.application.entity

import br.desafio.sincredi.application.utils.enums.StatusPauta
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
class Pauta extends BaseEntity {

   LocalDateTime dataInscricao
   Duration duracao
   LocalDateTime inicio
   Boolean aprovada
   StatusPauta status

}
