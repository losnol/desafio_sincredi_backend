package br.desafio.sincredi.application.entity

import br.desafio.sincredi.application.utils.enums.StatusSessao
import com.fasterxml.jackson.annotation.JsonBackReference
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.envers.Audited

import javax.persistence.*
import java.time.Duration
import java.time.LocalDateTime

@CompileStatic
@EqualsAndHashCode(excludes = ['inicio', 'pauta', 'duracao', 'votos', 'status'], callSuper = true)
@ToString(includeFields = true, includeNames = true, includePackage = false)
@Audited
@Entity
class Sessao extends BaseEntity {

   @MapsId
   @OneToOne(mappedBy = 'sessao')
   @JoinColumn(name = 'id')
   @JsonBackReference
   Pauta pauta

   @Column
   LocalDateTime inicio

   @Column
   Duration duracao

   @Column
   @OneToMany
   Set<Voto> votos = new HashSet<>()

   @Column(nullable = false)
   StatusSessao status

}
