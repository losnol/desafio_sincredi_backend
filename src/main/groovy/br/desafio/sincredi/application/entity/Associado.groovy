package br.desafio.sincredi.application.entity

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.Column
import javax.persistence.Entity
import java.time.LocalDate

@CompileStatic
@EqualsAndHashCode(excludes = ['nome', 'dataNascimento', 'cpf'], callSuper = true)
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
@Entity
class Associado extends BaseEntity {

   @Column(nullable = false)
   String nome

   @Column(nullable = false)
   LocalDate dataNascimento

   @Column(unique = true, nullable = false, length = 11)
   String cpf

}
