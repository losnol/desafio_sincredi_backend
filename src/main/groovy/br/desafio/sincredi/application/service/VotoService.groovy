package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.entity.Associado
import br.desafio.sincredi.application.entity.Voto
import br.desafio.sincredi.application.exception.MissingFieldException
import br.desafio.sincredi.application.exception.SincrediEntityNotFoundException
import br.desafio.sincredi.application.repository.jpa.VotoRepository
import org.springframework.stereotype.Service

@Service
class VotoService {

   private final VotoRepository repository
   private final SessaoService sessaoService

   VotoService(VotoRepository repository, SessaoService sessaoService) {
      this.repository = repository
      this.sessaoService = sessaoService
   }

   def create(Associado associado, Boolean aFavor, String sessaoId) throws SincrediEntityNotFoundException, MissingFieldException {
      def sessao = this.sessaoService.find(sessaoId)
      this.repository.saveAndFlush(new Voto(aFavor: aFavor, associado: associado, sessao: sessao))
   }

}
