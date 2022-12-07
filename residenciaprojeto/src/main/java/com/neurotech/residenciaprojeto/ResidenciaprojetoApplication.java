package com.neurotech.residenciaprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "API +Mulher", version = "1.0.1", description = "API do projeto da residencia 3 periodo."),
		servers = {
				@Server(url = "http://localhost:8080")
		}
		
		)
public class ResidenciaprojetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResidenciaprojetoApplication.class, args);
	}

}
