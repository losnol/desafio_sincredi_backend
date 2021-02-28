package br.desafio.sincredi.application.mapper

import br.desafio.sincredi.application.dto.response.PautaResponse
import br.desafio.sincredi.application.entity.Pauta
import br.desafio.sincredi.application.utils.enums.ResultadoPauta
import groovy.transform.CompileStatic

@CompileStatic
final class PautaMapper {

   private PautaMapper() {}

   static PautaResponse toResponse(Pauta pauta) {
      new PautaResponse(id: pauta.id.toString(), nomePauta: pauta.nomePauta, dataInscricao: pauta.dataInscricao,
            resultado: convertResultadoFromEntity(pauta))
   }


   static ResultadoPauta convertResultadoFromEntity(Pauta pauta) {
      if (pauta.aprovada == null)
         return ResultadoPauta.AGUARDANDO_VOTACAO
      pauta.aprovada ? ResultadoPauta.APROVADA : ResultadoPauta.REJEITADA
   }
}
