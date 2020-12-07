package es.masmovil.phone.app.customer.dto;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class CustomerDTO {

	@Id
	private String identifier;

	private String name;

	private String surname;

	private String email;
}
