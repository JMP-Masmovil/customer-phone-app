package es.masmovil.phone.app.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import es.masmovil.lib.customer.CustomerRSDTO;
import es.masmovil.lib.customer.client.CustomerFeignClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("/test.properties")
class TestCustomerController {

	@Autowired
	private CustomerFeignClient customerFeignClient;

	@Test
	void testController() {

		CustomerRSDTO customerRSDTO = new CustomerRSDTO();
		customerRSDTO.setName("Jose");
		customerRSDTO.setSurname("Martinez");
		customerRSDTO.setEmail("email@gmail.es");

		ResponseEntity<CustomerRSDTO> createResponseEntity = testCreate(customerRSDTO);

		testSearch(createResponseEntity.getBody());

		ResponseEntity<Void> responseDelete = customerFeignClient
				.deleteCustomer(createResponseEntity.getBody().getIdentifier());

		assertEquals(HttpStatus.NO_CONTENT, responseDelete.getStatusCode());

		ResponseEntity<Void> responseDelete2 = customerFeignClient
				.deleteCustomer(createResponseEntity.getBody().getIdentifier());

		assertEquals(HttpStatus.NOT_FOUND, responseDelete2.getStatusCode());

	}

	private ResponseEntity<CustomerRSDTO> testCreate(CustomerRSDTO customerRSDTO) {

		ResponseEntity<CustomerRSDTO> createResponseEntity = customerFeignClient.createCustomer(customerRSDTO);

		assertEquals(HttpStatus.CREATED, createResponseEntity.getStatusCode());
		CustomerRSDTO updatedCustomerRSDTO = createResponseEntity.getBody();

		assertNotNull(updatedCustomerRSDTO.getIdentifier());
		assertEquals(customerRSDTO.getName(), updatedCustomerRSDTO.getName());
		assertEquals(customerRSDTO.getSurname(), updatedCustomerRSDTO.getSurname());
		assertEquals(customerRSDTO.getEmail(), updatedCustomerRSDTO.getEmail());
		return createResponseEntity;
	}

	private void testSearch(CustomerRSDTO customerRSDTO) {

		ResponseEntity<CustomerRSDTO> createResponseEntity = customerFeignClient
				.getCustomer(customerRSDTO.getIdentifier());

		assertEquals(HttpStatus.OK, createResponseEntity.getStatusCode());
		CustomerRSDTO updatedCustomerRSDTO = createResponseEntity.getBody();

		assertEquals(customerRSDTO.getIdentifier(), updatedCustomerRSDTO.getIdentifier());
		assertEquals(customerRSDTO.getName(), updatedCustomerRSDTO.getName());
		assertEquals(customerRSDTO.getSurname(), updatedCustomerRSDTO.getSurname());
		assertEquals(customerRSDTO.getEmail(), updatedCustomerRSDTO.getEmail());

	}

}
