package br.desafio.sincredi.application.repository.jpa

import br.desafio.sincredi.application.entity.Associado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AssociadoRepository extends JpaRepository<Associado, UUID> {

   Optional<Associado> findByCpf(String cpf)

}
