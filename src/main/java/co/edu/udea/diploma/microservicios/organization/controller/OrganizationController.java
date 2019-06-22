package co.edu.udea.diploma.microservicios.organization.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.udea.diploma.microservicios.organization.client.DepartmentClient2;
import co.edu.udea.diploma.microservicios.organization.client.EmployeeClient2;
import co.edu.udea.diploma.microservicios.organization.model.Organization;
import co.edu.udea.diploma.microservicios.organization.repository.OrganizationCRUDRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	OrganizationCRUDRepository repository;

	@Autowired
	EmployeeClient2 employeeClient2;

	@Autowired
	DepartmentClient2 departmentClient2;

	@PostMapping
	public ResponseEntity<Organization> add(@RequestBody Organization organization) {
		log.info("Organization add: {}", organization);
		return ResponseEntity.ok(repository.save(organization));
	}

	@GetMapping
	public ResponseEntity<Iterable<Organization>> findAll() {
		log.info("Organization find");
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Organization> findById(@PathVariable("id") String id) {
		log.info("Organization find: id={}", id);
		return ResponseEntity.ok(repository.findById(id).get());
	}

	@GetMapping("/{id}/with-departments")
	public ResponseEntity<Organization> findByIdWithDepartments(@PathVariable("id") String id) {
		log.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		if (organization.isPresent()) {
			Organization o = organization.get();
			o.setDepartments(departmentClient2.findByOrganization(o.getId()));
			return ResponseEntity.ok(o);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}/with-departments-and-employees")
	public ResponseEntity<Organization> findByIdWithDepartmentsAndEmployees(@PathVariable("id") String id) {
		log.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		if (organization.isPresent()) {
			Organization o = organization.get();
			o.setDepartments(departmentClient2.findByOrganizationWithEmployees(o.getId()));
			return ResponseEntity.ok(o);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}/with-employees")
	public ResponseEntity<Organization> findByIdWithEmployees(@PathVariable("id") String id) {
		log.info("Organization find: id={}", id);
		Optional<Organization> organization = repository.findById(id);
		if (organization.isPresent()) {
			Organization o = organization.get();
			o.setEmployees(employeeClient2.findByOrganization(o.getId()));
			return ResponseEntity.ok(o);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
