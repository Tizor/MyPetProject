package application.implementation;

import application.dao.CustomerRepo;
import application.dto.CustomerDto;
import application.entity.Customer;
import application.mapper.CustomerMapper;
import application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Transactional
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customersFromDBList = customerRepo.findAll();
        return customerMapper.mapListOfCustomersToListOfCustomersDto(customersFromDBList);
    }

    @Transactional
    public void addCustomer(CustomerDto customer) {
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
    public CustomerDto updateCustomer(CustomerDto customer) {
        Customer customerBeforeUpdate = customerRepo.getOne(customer.getId());
        Customer customerForUpdate = customerMapper.mapCustomerFromCustomerDto(customerBeforeUpdate, customer);
        Customer customerAfterUpdate = customerRepo.save(customerForUpdate);
        return customerMapper.mapCustomerDtoFromCustomer(customerAfterUpdate, customer);
    }




}
