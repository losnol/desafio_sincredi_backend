package br.desafio.sincredi.application.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.query.Param

@NoRepositoryBean
interface SoftDeletableRepository<T, ID> extends JpaRepository<T, ID> {

   @Override
   @Query("select e from #{#entityName} e where e.excluida=false")
   List<T> findAll()

   @Query("select e from #{#entityName} e where e.excluida=true")
   List<T> findDeleted()

   @Query("update #{#entityName} e set e.excluida=true where :entity = e")
   @Modifying
   @Override
   void delete(@Param("entity") T entity)


}
