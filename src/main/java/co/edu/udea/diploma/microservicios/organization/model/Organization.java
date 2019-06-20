package co.edu.udea.diploma.microservicios.organization.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Organization {

	private Long id;
	private String name;
	private String address;
	private List<Department> departments = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	
	public Organization(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
