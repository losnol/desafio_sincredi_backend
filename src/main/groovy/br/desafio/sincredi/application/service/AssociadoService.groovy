package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.entity.Associado
import br.desafio.sincredi.application.exception.SincrediEntityNotFoundException
import br.desafio.sincredi.application.repository.jpa.AssociadoRepository
import org.springframework.stereotype.Service

import java.time.LocalDate

@Service
class AssociadoService {

   private final AssociadoRepository repository
   private final VotoService votoService

   AssociadoService(AssociadoRepository repository, VotoService votoService) {
      this.repository = repository
      this.votoService = votoService
   }

   def create(String cpf, String nome, LocalDate dataNascimento) {
      this.repository.save(new Associado(cpf: cpf, nome: nome, dataNascimento: dataNascimento))
   }

   def findByCpf(String cpf) throws SincrediEntityNotFoundException {
      this.repository.findByCpf(cpf).orElseThrow {
         new SincrediEntityNotFoundException('Associado', cpf)
      }
   }

   def findAll() {
      this.repository.findAll()
   }

   def vote(String cpf, Boolean aFavor, String sessaoId) throws SincrediEntityNotFoundException {
      this.votoService.create(this.findByCpf(cpf), aFavor, sessaoId)
   }

}
