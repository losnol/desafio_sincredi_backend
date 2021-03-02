package br.desafio.sincredi.application.resource.controller.rest


import br.desafio.sincredi.application.dto.request.CreateSessaoRequest
import br.desafio.sincredi.application.mapper.SessaoMapper
import br.desafio.sincredi.application.service.SessaoService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/sessao")
class SessaoRestController {

   private final SessaoService service

   SessaoRestController(SessaoService service) {
      this.service = service
   }

   @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   def create(@RequestBody CreateSessaoRequest req) {
      SessaoMapper.toResponse(this.service.create(req.pautaId, req.duracao))
   }

   @GetMapping(path = "/{pauta_id}", produces = MediaType.APPLICATION_JSON_VALUE)
   def get(@PathVariable("pauta_id") String pautaId) {
      SessaoMapper.toResponse(this.service.find(pautaId))
   }

   @PostMapping(path = '/abrir/{sessao_id}', produces = MediaType.APPLICATION_JSON_VALUE)
   def abrirSessao(@PathVariable('sessao_id') String sessaoId) {
      this.service.abrir(sessaoId)
      ResponseEntity.ok().build()
   }

}
