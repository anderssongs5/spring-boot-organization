package co.edu.udea.diploma.microservicios.organization.repository;

import java.util.List;

import co.edu.udea.diploma.microservicios.organization.model.Organization;

public interface OrganizationRepository {

	public Organization add(Organization organization);

	public Organization findById(Long id);

	public List<Organization> findAll();
}
