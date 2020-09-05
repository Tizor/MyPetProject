package application.service;

import application.dto.CustomerCreateDto;
import application.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


public interface CustomerService {

    Collection<Customer> getAllCustomers();
    void createCustomer(CustomerCreateDto customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
    Optional<Customer> findCustomerById(Long id);
}
