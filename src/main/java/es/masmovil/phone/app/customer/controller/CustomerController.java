package es.masmovil.phone.app.customer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.masmovil.lib.customer.CustomerRSDTO;
import es.masmovil.phone.app.customer.controller.transformer.CustomerControllerTransformer;
import es.masmovil.phone.app.customer.dto.CustomerDTO;
import es.masmovil.phone.app.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("${ms.api.basepath}")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerControllerTransformer customerControllerTransformer;

	@GetMapping("/{id}")
	public ResponseEntity<CustomerRSDTO> getCustomer(@PathVariable String id) {

		log.debug("inicio - getCustomer");
		CustomerDTO customerDto = customerService.getCustomerById(id);

		ResponseEntity<CustomerRSDTO> response;

		if (Optional.ofNullable(customerDto).isPresent()) {
			CustomerRSDTO customerRSDTO = customerControllerTransformer.toCustomerRSDto(customerDto);
			response = new ResponseEntity<>(customerRSDTO, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		log.debug("fin - getCustomer");

		return response;
	}

	@PostMapping("/")
	public ResponseEntity<CustomerRSDTO> createCustomer(@RequestBody CustomerRSDTO customerRSDTO) {

		log.debug("inicio - getCustomer");
		CustomerDTO customerDto = customerControllerTransformer.toCustomerDto(customerRSDTO);
		customerDto = customerService.createNewCustomer(customerDto);
		CustomerRSDTO customerResponseRSDTO = customerControllerTransformer.toCustomerRSDto(customerDto);
		log.debug("fin - getCustomer");

		return new ResponseEntity<>(customerResponseRSDTO, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {

		log.debug("inicio - deleteCustomer");
		boolean hasDelted = customerService.deleteCustomer(id);

		HttpStatus httpStatus;
		if (hasDelted) {
			httpStatus = HttpStatus.NO_CONTENT;
		} else {
			httpStatus = HttpStatus.NOT_FOUND;

		}
		
		return new ResponseEntity<>(httpStatus);

	}
}
