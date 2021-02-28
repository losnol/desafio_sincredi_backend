package br.desafio.sincredi.application.entity


import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.Column
import javax.persistence.Entity
import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode(excludes = ['nomePauta', 'dataInscricao', 'aprovada'], callSuper = true)
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
@Entity
class Pauta extends SoftDeletableEntity {

   @Column
   String nomePauta

   @Column
   LocalDateTime dataInscricao

   @Column
   Boolean aprovada

}
