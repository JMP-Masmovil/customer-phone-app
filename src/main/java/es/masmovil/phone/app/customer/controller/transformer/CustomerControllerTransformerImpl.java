package es.masmovil.phone.app.customer.controller.transformer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import es.masmovil.lib.customer.CustomerRSDTO;
import es.masmovil.phone.app.customer.dto.CustomerDTO;
import lombok.NonNull;

@Service
public class CustomerControllerTransformerImpl implements CustomerControllerTransformer {

	@Override
	public CustomerRSDTO toCustomerRSDto(@NonNull CustomerDTO customerDto) {

		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customerDto, CustomerRSDTO.class);

	}

	@Override
	public CustomerDTO toCustomerDto(@NonNull CustomerRSDTO customerRSDTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(customerRSDTO, CustomerDTO.class);
	}

}
