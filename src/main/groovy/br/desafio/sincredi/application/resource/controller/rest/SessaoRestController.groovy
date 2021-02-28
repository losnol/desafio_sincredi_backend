package br.desafio.sincredi.application.resource.controller.rest

import br.desafio.sincredi.application.service.SessaoService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/sessao")
class SessaoRestController {

   private final SessaoService service

   SessaoRestController(SessaoService service) {
      this.service = service
   }

   @PostMapping("/{pauta_id}")
   def create(@PathVariable("pauta_id") String pautaId) {
      this.service.create(pautaId)
   }

}
