package co.edu.udea.diploma.microservicios.organization.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.udea.diploma.microservicios.organization.model.Employee;

@Component
public class EmployeeClientImpl implements EmployeeClient {

	private final RestTemplate restTemplate;
	private final String employeeHost;

	@Autowired
	public EmployeeClientImpl(RestTemplate restTemplate, @Value("${employeeHost}") String employeeHost) {
		this.restTemplate = restTemplate;
		this.employeeHost = employeeHost;
	}

	@Override
	public List<Employee> findByOrganization(Long organizationId) {
		ResponseEntity<List<Employee>> response = restTemplate.exchange(
				employeeHost + "/organization/" + organizationId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		return response.getBody();
	}

}
