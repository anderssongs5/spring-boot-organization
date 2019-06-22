package co.edu.udea.diploma.microservicios.organization.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "organization")
public class Organization {

	@Id
	private String id;
	private String name;
	private String address;
	private List<Department> departments = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();

	public Organization(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
