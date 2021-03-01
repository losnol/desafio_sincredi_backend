package br.desafio.sincredi.application

import br.desafio.sincredi.application.resource.controller.rest.RestResponseEntityExceptionHandler
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
<<<<<<< Updated upstream
=======
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = 'br.desafio.sincredi.application.repository.jpa')
<<<<<<< Updated upstream
=======
@EnableJpaAuditing
@Import(RestResponseEntityExceptionHandler.class)
>>>>>>> Stashed changes
class Application {

	static void main(String[] args) {
		SpringApplication.run(Application, args)
	}

}
