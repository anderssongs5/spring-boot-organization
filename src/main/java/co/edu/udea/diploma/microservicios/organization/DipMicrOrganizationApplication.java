package co.edu.udea.diploma.microservicios.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import co.edu.udea.diploma.microservicios.organization.model.Organization;
import co.edu.udea.diploma.microservicios.organization.repository.OrganizationRepository;
import co.edu.udea.diploma.microservicios.organization.repository.OrganizationRepositoryImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DipMicrOrganizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DipMicrOrganizationApplication.class, args);
	}

	@Bean
	OrganizationRepository repository() {
		OrganizationRepository repository = new OrganizationRepositoryImpl();
		repository.add(new Organization("Microsoft", "Redmond, Washington, USA"));
		repository.add(new Organization("Oracle", "Redwood City, California, USA"));
		return repository;
	}
}
