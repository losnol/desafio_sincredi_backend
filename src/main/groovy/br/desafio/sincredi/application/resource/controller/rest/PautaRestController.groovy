package br.desafio.sincredi.application.resource.controller.rest

import br.desafio.sincredi.application.dto.request.CreatePautaRequest
import br.desafio.sincredi.application.service.PautaService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/pauta")
class PautaRestController {

   private final PautaService service

   PautaRestController(PautaService service) {
      this.service = service
   }

   @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   def criarPauta(@RequestBody CreatePautaRequest req) {
         return this.service.create(req.nomePauta)
   }

   @GetMapping(path = "/obter-resultado/{id}")
   def getResultadoPauta(@PathVariable("id") String id) {
      this.service.resultado(id)
   }

}
