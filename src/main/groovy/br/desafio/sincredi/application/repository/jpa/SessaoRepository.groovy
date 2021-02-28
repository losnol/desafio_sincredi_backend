package br.desafio.sincredi.application.repository.jpa

import br.desafio.sincredi.application.entity.Sessao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SessaoRepository extends JpaRepository<Sessao, UUID> {

}
