package com.ccti.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(
		info =  @Info(
				title = "Restrictive Bank System",
				description = "Proyecto Springboot",
				version = "v1",
				contact = @Contact(
						name = "Marco Celis",
						email = "mc@abc.com",
						url = "http://abc.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://abc.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Proyecto para microservicios springboot",
				url = "http://localhost:8080/swagger-ui/index.html#/"
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "AuditorAwareImpl")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
