package api.mrdelivery;

import static api.mrdelivery.util.constants.Role.ADMIN;
import static api.mrdelivery.util.constants.Role.CLERK;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import api.mrdelivery.dto.RegisterRequest;
import api.mrdelivery.service.AuthenticationService;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ApimrdeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimrdeliveryApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(CLERK)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}

}
