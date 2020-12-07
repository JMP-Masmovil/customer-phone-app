package es.masmovil.phone.app.customer.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import es.masmovil.phone.app.customer.persistence.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{

}
