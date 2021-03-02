package br.desafio.sincredi.application.mapper

import br.desafio.sincredi.application.dto.response.VotoResponse
import br.desafio.sincredi.application.dto.to.VotoTO
import br.desafio.sincredi.application.entity.Voto
import br.desafio.sincredi.application.utils.enums.VotoEnum
import groovy.transform.CompileStatic

@CompileStatic
final class VotoMapper {

   private VotoMapper() {
   }

   static VotoTO toTO(Voto voto) {
      new VotoTO(valor: voto.aFavor ? VotoEnum.SIM : VotoEnum.NAO, cpfAssociado: voto.associado.cpf)
   }

   static VotoResponse toResponse(Voto voto) {
      new VotoResponse(valor: voto.aFavor ? VotoEnum.SIM : VotoEnum.NAO, cpfAssociado: voto.associado.cpf,
            idSessao: voto.sessao.id.toString())
   }

}
