package br.desafio.sincredi.application.repository.jpa

import br.desafio.sincredi.application.entity.Pauta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PautaRepository extends JpaRepository<Pauta, UUID> {
}
