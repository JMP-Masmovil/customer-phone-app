package es.masmovil.phone.app.customer.persistence.transformer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import es.masmovil.phone.app.customer.dto.CustomerDTO;
import es.masmovil.phone.app.customer.persistence.Customer;
import lombok.NonNull;

@Service
public class PersistenceTransformerImpl implements PersistenceTransformer {



	@Override
	public CustomerDTO toCustomerDto(@NonNull Customer customer) {

		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customer, CustomerDTO.class);

	}

	@Override
	public Customer toCustomer(@NonNull CustomerDTO customerDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customerDTO, Customer.class);

	}

}
