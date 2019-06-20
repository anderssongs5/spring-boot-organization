package co.edu.udea.diploma.microservicios.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.diploma.microservicios.organization.client.DepartmentClient2;
import co.edu.udea.diploma.microservicios.organization.client.EmployeeClient2;
import co.edu.udea.diploma.microservicios.organization.model.Organization;
import co.edu.udea.diploma.microservicios.organization.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	OrganizationRepository repository;

//	@Autowired
//	EmployeeClient employeeClient;
//
//	@Autowired
//	DepartmentClient departmentClient;

	@Autowired
	EmployeeClient2 employeeClient2;

	@Autowired
	DepartmentClient2 departmentClient2;

	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		log.info("Organization add: {}", organization);
		return repository.add(organization);
	}

	@GetMapping
	public List<Organization> findAll() {
		log.info("Organization find");
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Organization findById(@PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		return repository.findById(id);
	}

	@GetMapping("/{id}/with-employees")
	public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		//organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
		organization.setEmployees(employeeClient2.findByOrganization(organization.getId()));
		return organization;
	}

	@GetMapping("/{id}/with-departments")
	public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		//organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
		organization.setDepartments(departmentClient2.findByOrganization(organization.getId()));
		return organization;
	}

	@GetMapping("/{id}/with-departments-and-employees")
	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		Organization organization = repository.findById(id);
		//organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
		organization.setDepartments(departmentClient2.findByOrganizationWithEmployees(organization.getId()));
		return organization;
	}
}
