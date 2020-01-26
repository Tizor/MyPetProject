package application.implementation;

import application.dao.CustomerRepo;
import application.dto.CustomerCreateDto;
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
    public void addCustomer(CustomerCreateDto customer) {
        Customer newCustomer = new Customer();
        customerMapper.mapCustomerFromCustomerCreateDto(newCustomer, customer);
        customerRepo.save(newCustomer);
    }
}
