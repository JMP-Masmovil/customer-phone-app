package es.masmovil.phone.app.customer.service;

import es.masmovil.phone.app.customer.dto.CustomerDTO;

public interface CustomerService {


	/**
	 * Search customer by id
	 * @param id The customer Id
	 * @return The CustomerDTO
	 */
	CustomerDTO getCustomerById(String id);
	
	/**
	 * Create new customer
	 * @param customerDTO The customer
	 * @return The customerDTO
	 */
	CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	
	/**
	 * Delete customer by id
	 * @param id The customer id
	 * @return if the delete has performed
	 */
	boolean deleteCustomer(String id);

}
