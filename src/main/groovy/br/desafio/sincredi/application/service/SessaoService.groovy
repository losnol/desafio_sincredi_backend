package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.entity.Sessao
import br.desafio.sincredi.application.repository.jpa.SessaoRepository
import br.desafio.sincredi.application.utils.enums.StatusSessao
import org.springframework.stereotype.Service

@Service
class SessaoService {

   private final PautaService pautaService
   private final SessaoRepository repository

   SessaoService(PautaService pautaService, SessaoRepository repository) {
      this.pautaService = pautaService
      this.repository = repository
   }

   def create(String pautaId) {
      def pauta = this.pautaService.get(pautaId).get()
      def sessao = new Sessao(pauta: pauta, status: StatusSessao.AGUARDANDO)
      this.repository.saveAndFlush(sessao)
   }

   def delete(Sessao sessao) {
      this.repository.delete(sessao)
   }

}
