package es.masmovil.phone.app.customer.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.masmovil.phone.app.customer.dto.CustomerDTO;
import es.masmovil.phone.app.customer.persistence.Customer;
import es.masmovil.phone.app.customer.persistence.repository.CustomerRepository;
import es.masmovil.phone.app.customer.persistence.transformer.PersistenceTransformer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PersistenceTransformer persistenceTransformer;

	@Override
	public CustomerDTO getCustomerById(String id) {
		
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			return persistenceTransformer.toCustomerDto(customer.get());
		}

		return null;
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

		Customer customer = persistenceTransformer.toCustomer(customerDTO);
		customer.setIdentifier(UUID.randomUUID().toString());
		customer = customerRepository.save(customer);
		return persistenceTransformer.toCustomerDto(customer);

	}

	@Override
	public boolean deleteCustomer(String id) {

		if(customerRepository.existsById(id)) {
			customerRepository.deleteById(id);
			return true;
		}
		
		return false;
	}


}
