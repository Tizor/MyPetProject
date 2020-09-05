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
    private final FinalOrderRepo finalOrderRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, FinalOrderRepo finalOrderRepo) {
        this.customerRepo = customerRepo;
        this.finalOrderRepo = finalOrderRepo;
    }

    @Transactional
    public Collection<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Transactional
    public Optional<Customer> findCustomerById(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        customer.get().setOrders(finalOrderRepo.getChildNotes(id));
        return customer;
    }

    @Transactional
    public void createCustomer(@RequestBody CustomerCreateDto customerDto) {
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
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

}
