package application.implementation;

import application.dao.CustomerRepo;
import application.dto.customer.CustomerCreateDto;
import application.dto.customer.CustomerDto;
import application.dto.customer.CustomerForUpdateDto;
import application.entity.Customer;
import application.mapper.CustomerMapper;
import application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Transactional
    public Collection<CustomerDto> getAllCustomers() {
        List<Customer> customersFromDBList = customerRepo.findAll();
        return customerMapper.mapListOfCustomersToListOfCustomersDto(customersFromDBList);
    }

    @Transactional
    public void addCustomer(CustomerCreateDto customer) {
        Customer newCustomer = new Customer();
        customerMapper.mapCustomerFromCustomerCreateDto(newCustomer, customer);
        customerRepo.save(newCustomer);
    }

    @Transactional
    public void deleteCustomer(UUID id) {
        customerRepo.deleteById(id);
    }

    @Transactional
    public CustomerDto getCustomerById(UUID id) {
        Customer customerFromDB = customerRepo.getOne(id);
        CustomerDto customerDto = new CustomerDto();
        return customerMapper.mapCustomerDtoFromCustomer(customerFromDB, customerDto);
    }

    @Transactional
    public CustomerDto updateCustomer(CustomerForUpdateDto customer) {
        Customer customerBeforeUpdate = customerRepo.getOne(customer.getId());
        Customer customerForUpdate = customerRepo.save(customerMapper.mapUpdateCustomerFromCustomerDto(customerBeforeUpdate, customer));
        CustomerDto customerDto = new CustomerDto(); //полная хрень. Лучше создание сущности запихнуть в маппер;
        CustomerDto customerAfterUpdate = customerMapper.mapCustomerDtoFromCustomer(customerForUpdate, customerDto);
        return customerMapper.mapUpdateCustomerDtoToCustomerDto(customerAfterUpdate, customer);
    }




}
