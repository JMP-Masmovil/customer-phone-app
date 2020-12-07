package es.masmovil.phone.app.customer.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "customers")
@Getter
@Setter
public class Customer {

	@Id
	private String identifier;

	private String name;

	private String surname;

	private String email;
}
