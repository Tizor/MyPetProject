package application.implementation;

import application.dao.CustomerRepo;
import application.dto.CustomerCreateDto;
import application.dto.CustomerDto;
import application.entity.Customer;
import application.mapper.CustomerMapper;
import application.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customersFromDBList = customerRepo.findAll();
        return customerMapper.mapListOfCustomersToListOfCustomersDto(customersFromDBList);
    }

    @Transactional
    public CustomerDto getCustomerById(UUID id) {
        return null;
    }

    @Transactional
    public CustomerDto updateCustomer(CustomerDto customer) {
        return null;
    }

    @Transactional
    public void deleteCustomer(UUID id) {

    }

    @Transactional
    public void updateCustomer(CustomerCreateDto customer) {

    }
}