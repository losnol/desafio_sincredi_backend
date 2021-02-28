package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.entity.Pauta
import br.desafio.sincredi.application.entity.Sessao
import br.desafio.sincredi.application.mapper.PautaMapper
import br.desafio.sincredi.application.repository.jpa.PautaRepository
import org.springframework.stereotype.Service

import java.time.LocalDateTime

@Service
class PautaService {

   private final PautaRepository repository
   private final SessaoService sessaoService

   PautaService(PautaRepository repository, SessaoService sessaoService) {
      this.repository = repository
      this.sessaoService = sessaoService
   }

   def create(String nomePauta) {
      def pauta = new Pauta(dataInscricao: LocalDateTime.now(), nomePauta: nomePauta)
      this.repository.save(pauta)
   }

   def getResultado(String id) {
      def pauta = this.repository.getOne(UUID.fromString(id))
      PautaMapper.convertResultadoFromEntity(pauta)
   }

   def get(String id) {
      this.repository.findById(UUID.fromString(id))
   }

   def getAll() {
      this.repository.findAll()
   }

   def delete(String id) {
      def pauta = this.repository.findById(UUID.fromString(id)).get()
      this.repository.delete(pauta)
   }

   def addSessao(Pauta pauta, Sessao sessao) {
      pauta.sessao = sessao
      this.repository.saveAndFlush(pauta)
   }

}
