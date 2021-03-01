package br.desafio.sincredi.application.mapper

import br.desafio.sincredi.application.dto.response.SessaoResponse
import br.desafio.sincredi.application.dto.to.DuracaoPautaTO
import br.desafio.sincredi.application.dto.to.VotoTO
import br.desafio.sincredi.application.entity.Sessao
import groovy.transform.CompileStatic

import java.time.Duration
import java.util.stream.Collectors

@CompileStatic
final class SessaoMapper {

   private SessaoMapper() {}

   static SessaoResponse toResponse(Sessao sessao) {
      def pauta = PautaMapper.toResponse(sessao.pauta)
      Set<VotoTO> votos = sessao.votos.stream().map {
         VotoMapper.toTO(it)
      }.collect(Collectors.toSet())
      new SessaoResponse(pauta: pauta, duracao: fromDurationToDurationPautaTO(sessao.duracao), status: sessao.status,
            votos: votos)
   }

   static Duration fromDurationPautaTOToDuration(DuracaoPautaTO to) {
      Duration.ZERO
            .plusHours(to.horas)
            .plusMinutes(to.minutos)
            .plusSeconds(to.segundos)
   }

   static DuracaoPautaTO fromDurationToDurationPautaTO(Duration duration) {
      new DuracaoPautaTO(horas: duration.toHoursPart(), minutos: duration.toMinutesPart(), segundos: duration.toSecondsPart())
   }

}
