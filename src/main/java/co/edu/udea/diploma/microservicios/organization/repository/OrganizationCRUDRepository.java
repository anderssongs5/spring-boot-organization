package co.edu.udea.diploma.microservicios.organization.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.udea.diploma.microservicios.organization.model.Organization;

public interface OrganizationCRUDRepository extends CrudRepository<Organization, String> {

}
