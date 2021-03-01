package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.dto.to.DuracaoPautaTO
import br.desafio.sincredi.application.entity.Sessao
import br.desafio.sincredi.application.exception.MissingFieldException
import br.desafio.sincredi.application.exception.SincrediEntityNotFoundException
import br.desafio.sincredi.application.mapper.SessaoMapper
import br.desafio.sincredi.application.repository.jpa.SessaoRepository
import br.desafio.sincredi.application.utils.IdUtil
import br.desafio.sincredi.application.utils.NullCheckUtil
import br.desafio.sincredi.application.utils.enums.StatusSessao
import org.springframework.stereotype.Service

import java.time.Duration
import java.time.LocalDateTime
import java.util.concurrent.CompletableFuture

@Service
class SessaoService {

   private final PautaService pautaService
   private final SessaoRepository repository

   SessaoService(PautaService pautaService, SessaoRepository repository) {
      this.pautaService = pautaService
      this.repository = repository
   }

   def create(String pautaId, DuracaoPautaTO duracaoTO) throws SincrediEntityNotFoundException, MissingFieldException {
      NullCheckUtil.check(pautaId)
      def pauta = this.pautaService.get(pautaId)
      def duracao = Duration.ZERO
      if (!duracaoTO || (!duracaoTO.segundos && !duracaoTO.minutos && !duracaoTO.horas))
         duracao = duracao.plusMinutes(1)
      else
         duracao = SessaoMapper.fromDurationPautaTOToDuration(duracaoTO)
      def sessao = new Sessao(pauta: pauta, status: StatusSessao.AGUARDANDO, duracao: duracao)
      this.repository.saveAndFlush(sessao)
   }

   def find(String pautaId) throws SincrediEntityNotFoundException, MissingFieldException {
      NullCheckUtil.check(pautaId)
      this.repository.findById(IdUtil.uUIDFromString(pautaId)).orElseThrow {
         new SincrediEntityNotFoundException('Sessao', pautaId)
      }
   }

   def abrir(String sessaoId) throws MissingFieldException, SincrediEntityNotFoundException {
      NullCheckUtil.check(sessaoId)
      def sessao = this.repository.findById(IdUtil.uUIDFromString(sessaoId)).orElseThrow {
         new SincrediEntityNotFoundException('Sessao', sessaoId)
      }
      sessao.status = StatusSessao.ABERTA
      sessao.pauta.dataInscricao = LocalDateTime.now()
      this.repository.saveAndFlush(sessao)
      this.timeoutSessao(sessao)
   }

   private timeoutSessao(Sessao sessao) {
      CompletableFuture.runAsync {
         Thread.sleep(sessao.duracao.toMillis())
         sessao.setStatus(StatusSessao.FINALIZADA)
         this.repository.saveAndFlush(sessao)
      }
   }

}
