package co.edu.udea.diploma.microservicios.organization.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Department {

	private Long id;
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Department(String name) {
		super();
		this.name = name;
	}

}
