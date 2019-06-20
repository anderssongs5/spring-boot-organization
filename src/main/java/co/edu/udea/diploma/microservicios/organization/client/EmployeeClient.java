package co.edu.udea.diploma.microservicios.organization.client;

import java.util.List;

import co.edu.udea.diploma.microservicios.organization.model.Employee;

public interface EmployeeClient {

	List<Employee> findByOrganization(final Long organizationId);
}
