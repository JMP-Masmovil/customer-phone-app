package es.masmovil.phone.app.customer.persistence.transformer;

import es.masmovil.phone.app.customer.dto.CustomerDTO;
import es.masmovil.phone.app.customer.persistence.Customer;
import lombok.NonNull;

/**
 * Transformer between persistence layer and business layer
 * @author JMP87
 *
 */
public interface PersistenceTransformer {

	/**
	 * Transform Customer to CustomerDTO
	 * @param customer The Customer
	 * @return The CustomerDTO
	 */
	CustomerDTO toCustomerDto(@NonNull Customer customer);
	
	/**
	 * Transform CustomerDTO to Customer
	 * @param customerDTO The CustomerDTO
	 * @return The Customer
	 */
	Customer toCustomer(@NonNull CustomerDTO customerDTO);

}
