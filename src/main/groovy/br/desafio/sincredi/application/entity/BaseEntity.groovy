package br.desafio.sincredi.application.entity

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import javax.persistence.*
import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includeFields = true, includeNames = true, includePackage = false)
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class BaseEntity {

   @Id
   @GeneratedValue
   @Column(name = 'id')
   UUID id

   @Column(updatable = false)
   @CreationTimestamp
   @CreatedDate
   LocalDateTime createdAt

   @UpdateTimestamp
   @Column
   @LastModifiedDate
   LocalDateTime updatedAt

}
