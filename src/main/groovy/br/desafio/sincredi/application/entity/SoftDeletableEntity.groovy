package br.desafio.sincredi.application.entity

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.MappedSuperclass

@CompileStatic
@EqualsAndHashCode(callSuper = true, excludes = 'excluida')
@ToString(includeFields = true, includeNames = true, includePackage = false)
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class SoftDeletableEntity extends BaseEntity {

   @Column(nullable = false)
   Boolean excluida

}
