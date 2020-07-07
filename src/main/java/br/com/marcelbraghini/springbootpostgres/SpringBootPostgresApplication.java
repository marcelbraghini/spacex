package br.com.marcelbraghini.springbootpostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgresApplication.class, args);
	}

}

