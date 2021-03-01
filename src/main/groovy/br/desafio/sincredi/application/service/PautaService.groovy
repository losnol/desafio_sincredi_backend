package br.desafio.sincredi.application.service

import br.desafio.sincredi.application.entity.Pauta
import br.desafio.sincredi.application.exception.InvalidUUIDException
import br.desafio.sincredi.application.exception.MissingFieldException
import br.desafio.sincredi.application.exception.SincrediEntityNotFoundException
import br.desafio.sincredi.application.mapper.PautaMapper
import br.desafio.sincredi.application.repository.jpa.PautaRepository
import br.desafio.sincredi.application.utils.IdUtil
import br.desafio.sincredi.application.utils.NullCheckUtil
import org.springframework.stereotype.Service

import javax.persistence.EntityNotFoundException
import java.time.LocalDateTime

@Service
class PautaService {

   private final PautaRepository repository

   PautaService(PautaRepository repository) {
      this.repository = repository
   }

   def create(String nomePauta) {
      def pauta = new Pauta(dataInscricao: LocalDateTime.now(), nomePauta: nomePauta, excluida: false)
      this.repository.save(pauta)
   }

   def getResultado(String id) throws EntityNotFoundException, MissingFieldException, InvalidUUIDException {
      NullCheckUtil.check(id)
      try {
         def pauta = this.repository.getOne(UUID.fromString(id))
         PautaMapper.convertResultadoFromEntity(pauta)
      } catch (EntityNotFoundException e) {
         throw new SincrediEntityNotFoundException(e, 'Pauta', id)
      } catch (IllegalArgumentException e) {
         throw new InvalidUUIDException(id, e)
      }
   }

   def get(String id) throws SincrediEntityNotFoundException, InvalidUUIDException {
      this.repository.findById(IdUtil.uUIDFromString(id)).orElseThrow {
         new SincrediEntityNotFoundException('Pauta', id)
      }
   }

   def getAll() {
      this.repository.findAll()
   }

   def delete(String id) throws SincrediEntityNotFoundException, MissingFieldException {
      NullCheckUtil.check(id)
      def pauta = this.repository.findById(IdUtil.uUIDFromString(id)).orElseThrow {
         new SincrediEntityNotFoundException('Pauta', id)
      }
      this.repository.delete(pauta)
   }

   def getDeleted() {
      this.repository.findDeleted()
   }

}
