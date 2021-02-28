package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.dto.to.DuracaoPautaTO
import br.desafio.sincredi.application.entity.Pauta
import br.desafio.sincredi.application.repository.jpa.PautaRepository
import br.desafio.sincredi.application.utils.enums.ResultadoPauta
import br.desafio.sincredi.application.utils.enums.StatusSessao
import org.springframework.stereotype.Service

import java.time.Duration
import java.time.LocalDateTime

@Service
class PautaService {

   private final PautaRepository repository

   PautaService(PautaRepository repository) {
      this.repository = repository
   }

   def create(String nomePauta) {
      def pauta = new Pauta(dataInscricao: LocalDateTime.now(), nomePauta: nomePauta)
      this.repository.save(pauta)
   }

   def resultado(String pautaId){
      def pauta = this.repository.getOne(UUID.fromString(pautaId))
      pauta.aprovada ? ResultadoPauta.APROVADA : ResultadoPauta.REJEITADA
   }

}
