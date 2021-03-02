package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.entity.Associado
import br.desafio.sincredi.application.entity.Voto
import br.desafio.sincredi.application.exception.MissingFieldException
import br.desafio.sincredi.application.exception.SessaoFechadaException
import br.desafio.sincredi.application.exception.SincrediEntityNotFoundException
import br.desafio.sincredi.application.repository.jpa.VotoRepository
import br.desafio.sincredi.application.utils.enums.StatusSessao
import org.springframework.stereotype.Service

@Service
class VotoService {

   private final VotoRepository repository
   private final SessaoService sessaoService
   private final PautaService pautaService

   VotoService(VotoRepository repository, SessaoService sessaoService, PautaService pautaService) {
      this.repository = repository
      this.sessaoService = sessaoService
      this.pautaService = pautaService
   }

   def create(Associado associado, Boolean aFavor, String sessaoId) throws SincrediEntityNotFoundException,
         MissingFieldException, SessaoFechadaException {
      def sessao = this.sessaoService.find(sessaoId)
      if (sessao.status != StatusSessao.ABERTA)
         throw new SessaoFechadaException(sessaoId)
      this.repository.saveAndFlush(new Voto(aFavor: aFavor, associado: associado, sessao: sessao))
   }

}
