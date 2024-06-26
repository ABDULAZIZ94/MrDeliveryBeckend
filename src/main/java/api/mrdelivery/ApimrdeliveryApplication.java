package api.mrdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ApimrdeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimrdeliveryApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(
	// 		AuthenticationService service) {
	// 	return args -> {
	// 		var admin = RegisterRequest.builder()
	// 				.firstname("Admin")
	// 				.lastname("Admin")
	// 				.email("admin@mail.com")
	// 				.password("password")
	// 				.role(ADMIN)
	// 				.build();
	// 		System.out.println("Admin token: " + service.register(admin).getAccessToken());

	// 		var manager = RegisterRequest.builder()
	// 				.firstname("Admin")
	// 				.lastname("Admin")
	// 				.email("manager@mail.com")
	// 				.password("password")
	// 				.role(CLERK)
	// 				.build();
	// 		System.out.println("Manager token: " + service.register(manager).getAccessToken());

	// 	};
	// }

}
