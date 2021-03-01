package br.desafio.sincredi.application.mapper

import br.desafio.sincredi.application.dto.response.AssociadoResponse
import br.desafio.sincredi.application.entity.Associado
import groovy.transform.CompileStatic

@CompileStatic
final class AssociadoMapper {

   private AssociadoMapper(){}

   static AssociadoResponse toResponse(Associado associado) {
      new AssociadoResponse(cpf: associado.cpf, nome: associado.nome, dataNascimento: associado.dataNascimento)
   }

}
