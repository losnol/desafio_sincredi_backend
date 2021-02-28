package br.desafio.sincredi.application.entity

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.*
import java.time.LocalDate

@CompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
class Sessao extends BaseEntity {

   @MapsId
   @OneToOne(mappedBy = 'id')
   @JoinColumn(name = 'id')
   Pauta pauta

   @Column
   LocalDate data

   @Column
   @OneToMany
   Set<Voto> votos

}
