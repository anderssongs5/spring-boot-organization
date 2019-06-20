package co.edu.udea.diploma.microservicios.organization.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.udea.diploma.microservicios.organization.model.Department;

@FeignClient(value = "department-service")
public interface DepartmentClient2 {

	@GetMapping("/departments/organization/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId);

	@GetMapping("/departments/organization/{organizationId}/with-employees")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);
}
