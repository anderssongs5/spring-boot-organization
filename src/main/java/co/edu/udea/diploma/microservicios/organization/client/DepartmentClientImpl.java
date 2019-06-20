package co.edu.udea.diploma.microservicios.organization.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.udea.diploma.microservicios.organization.model.Department;

@Component
public class DepartmentClientImpl implements DepartmentClient {

	private final RestTemplate restTemplate;
	private final String departmentHost;

	@Autowired
	public DepartmentClientImpl(RestTemplate restTemplate, @Value("${departmentHost}") String departmentHost) {
		this.restTemplate = restTemplate;
		this.departmentHost = departmentHost;
	}

	@Override
	public List<Department> findByOrganization(Long organizationId) {
		ResponseEntity<List<Department>> response = restTemplate.exchange(
				departmentHost + "/organization/" + organizationId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Department>>() {
				});
		return response.getBody();
	}

	@Override
	public List<Department> findByOrganizationWithEmployees(Long organizationId) {
		ResponseEntity<List<Department>> response = restTemplate.exchange(
				departmentHost + "/organization/" + organizationId + "/with-employees", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Department>>() {
				});
		return response.getBody();
	}

}
