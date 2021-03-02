package br.desafio.sincredi.application.resource.controller.rest

import br.desafio.sincredi.application.dto.request.CreatePautaRequest
import br.desafio.sincredi.application.mapper.PautaMapper
import br.desafio.sincredi.application.service.PautaService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.util.stream.Collectors

@RestController
@RequestMapping("/v1/pauta")
class PautaRestController {

   private final PautaService service

   PautaRestController(PautaService service) {
      this.service = service
   }

   @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   def criarPauta(@RequestBody CreatePautaRequest req) {
      PautaMapper.toResponse(this.service.create(req.nomePauta))
   }

   @GetMapping(path = "/obter-resultado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   def getResultadoPauta(@PathVariable("id") String id) {
      this.service.getResultado(id)
   }

   @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   def getPauta(@PathVariable("id") String id) {
      PautaMapper.toResponse(this.service.get(id))
   }

   @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   def deletePauta(@PathVariable("id") String id) {
      this.service.delete(id)
      ResponseEntity.noContent().build()
   }

   @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
   def getAll() {
      this.service.getAll().stream().map {
         PautaMapper.toResponse(it)
      }.collect(Collectors.toList())
   }

   @GetMapping(path = "/excluidas/", produces = MediaType.APPLICATION_JSON_VALUE)
   def getDeleted() {
      this.service.getDeleted().stream().map {
         PautaMapper.toResponse(it)
      }.collect(Collectors.toList())
   }

}
