package br.desafio.sincredi.application.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.*
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

   @OneToOne(cascade = CascadeType.ALL)
   @JsonManagedReference
   @PrimaryKeyJoinColumn
   Sessao sessao

}
