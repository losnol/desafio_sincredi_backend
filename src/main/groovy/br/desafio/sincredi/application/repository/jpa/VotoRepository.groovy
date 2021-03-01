package br.desafio.sincredi.application.repository.jpa

import br.desafio.sincredi.application.entity.Voto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VotoRepository extends JpaRepository<Voto, UUID> {

}
