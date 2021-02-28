package br.desafio.sincredi.application.entity


import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.Column
import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
class Pauta extends BaseEntity {

   @Column
   String nomePauta

   @Column
   LocalDateTime dataInscricao

   @Column
   Boolean aprovada

}
