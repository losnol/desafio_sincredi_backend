package br.desafio.sincredi.application.entity

import br.desafio.sincredi.application.utils.enums.StatusSessao
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.*
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode(excludes = ['inicio', 'pauta', 'duracao', 'votos', 'status'], callSuper = true)
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
class Sessao extends BaseEntity {

   @MapsId
   @OneToOne(mappedBy = 'id')
   @JoinColumn(name = 'id')
   Pauta pauta

   @Column
   LocalDateTime inicio

   @Column
   Duration duracao

   @Column
   @OneToMany
   Set<Voto> votos

   @Column
   StatusSessao status

}
