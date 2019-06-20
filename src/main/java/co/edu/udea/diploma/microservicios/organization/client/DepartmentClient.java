package co.edu.udea.diploma.microservicios.organization.client;

import java.util.List;

import co.edu.udea.diploma.microservicios.organization.model.Department;

public interface DepartmentClient {

	public List<Department> findByOrganization(Long organizationId);

	public List<Department> findByOrganizationWithEmployees(Long organizationId);
}
