package application.service.impl;

import application.dao.CustomerRepo;
import application.dao.FinalOrderRepo;
import application.dto.CustomerCreateDto;
import application.entity.Customer;
import application.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, FinalOrderRepo finalOrderRepo) {
        this.customerRepo = customerRepo;
    }

    @Transactional
    public Collection<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Transactional
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepo.getCustomerFetchById(id);
    }

    @Transactional
    public void createCustomer(CustomerCreateDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setAge(customerDto.getAge());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        customer.setOrders(null);
        customerRepo.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

}
