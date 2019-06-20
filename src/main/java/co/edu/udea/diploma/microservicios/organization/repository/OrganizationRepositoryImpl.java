package co.edu.udea.diploma.microservicios.organization.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.udea.diploma.microservicios.organization.model.Organization;

public class OrganizationRepositoryImpl implements OrganizationRepository {

	private List<Organization> organizations = new ArrayList<>();

	@Override
	public Organization add(Organization organization) {
		organization.setId((long) (organizations.size() + 1));
		organizations.add(organization);
		return organization;
	}

	@Override
	public Organization findById(Long id) {
		Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (organization.isPresent())
			return organization.get();
		else
			return null;
	}

	@Override
	public List<Organization> findAll() {
		return organizations;
	}

}
