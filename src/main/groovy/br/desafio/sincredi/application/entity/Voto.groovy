package br.desafio.sincredi.application.entity

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne

@CompileStatic
@EqualsAndHashCode(excludes = ['aFavor', 'associado'], callSuper = true)
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
@Entity
class Voto extends BaseEntity {

   @Column
   Boolean aFavor

   @ManyToOne
   Associado associado

}
