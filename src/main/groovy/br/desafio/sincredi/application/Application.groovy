package br.desafio.sincredi.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = 'br.desafio.sincredi.application.repository.jpa')
@EnableJpaAuditing
class Application {

	static void main(String[] args) {
		SpringApplication.run(Application, args)
	}

}
