package br.desafio.sincredi.application.resource.controller.rest

import br.desafio.sincredi.application.dto.request.CreateAssociadoRequest
import br.desafio.sincredi.application.dto.request.VotoRequest
import br.desafio.sincredi.application.mapper.AssociadoMapper
import br.desafio.sincredi.application.mapper.VotoMapper
import br.desafio.sincredi.application.service.AssociadoService
import br.desafio.sincredi.application.utils.enums.VotoEnum
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

import java.util.stream.Collectors

@RestController
@RequestMapping('/v1/associado')
class AssociadoRestController {

   private final AssociadoService service

   AssociadoRestController(AssociadoService service) {
      this.service = service
   }

   @PutMapping(path = '/', consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   def create(@RequestBody CreateAssociadoRequest req) {
      AssociadoMapper.toResponse(this.service.create(req.cpf, req.nome, req.dataNascimento))
   }

   @GetMapping(path = '/{cpf}', produces = MediaType.APPLICATION_JSON_VALUE)
   def get(@PathVariable('cpf') String cpf) {
      AssociadoMapper.toResponse(this.service.findByCpf(cpf))
   }

   @GetMapping(path = '/', produces = MediaType.APPLICATION_JSON_VALUE)
   def getAll() {
      this.service.findAll().stream().map {
         AssociadoMapper.toResponse(it)
      }.collect(Collectors.toList())
   }

   @PutMapping(path = '/votar/', consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   def vote(@RequestBody VotoRequest req) {
      VotoMapper.toResponse(this.service.vote(req.cpf, req.voto == VotoEnum.SIM, req.idPauta))
   }

}
