package es.masmovil.phone.app.customer.controller.transformer;

import es.masmovil.lib.customer.CustomerRSDTO;
import es.masmovil.phone.app.customer.dto.CustomerDTO;
import lombok.NonNull;

/**
 * Transformer between service layer and rest layer
 * @author JMP87
 *
 */
public interface CustomerControllerTransformer {


	
	/**
	 * Transform the CustomerDTO to CustomerRSDTO
	 * @param customerDto The CustomerDTO
	 * @return The CustomerRSDTO
	 */
	CustomerRSDTO toCustomerRSDto(@NonNull CustomerDTO customerDto);
	
	
	/**
	 * Transform the CustomerRSDTO to CustomerDTO
	 * @param customerDto The CustomerRSDTO
	 * @return The CustomerDTO
	 */
	CustomerDTO toCustomerDto(@NonNull CustomerRSDTO customerRSDTO);
	
}
