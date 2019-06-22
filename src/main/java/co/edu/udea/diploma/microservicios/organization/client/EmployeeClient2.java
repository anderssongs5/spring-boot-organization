package co.edu.udea.diploma.microservicios.organization.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.udea.diploma.microservicios.organization.model.Employee;

@FeignClient(value = "employee-service")
public interface EmployeeClient2 {

	@GetMapping("/employees/organization/{organizationId}")
	List<Employee> findByOrganization(@PathVariable("organizationId") String organizationId);
}
