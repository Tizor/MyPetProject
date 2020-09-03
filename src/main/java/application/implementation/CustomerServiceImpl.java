package application.implementation;

import application.dao.CustomerRepo;
import application.dao.FinalOrderRepo;
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
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final FinalOrderRepo finalOrderRepo;
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
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    @Transactional
    public CustomerDto getCustomerById(Long id) {
        Optional<Customer> customerFromDB = customerRepo.findById(id);
//        customerFromDB.get().setOrder(finalOrderRepo.getFinalOrder(id));
        CustomerDto customerDto = new CustomerDto();
        return customerMapper.mapCustomerDtoFromCustomer(customerFromDB.get(), customerDto);
    }

    @Transactional
    public CustomerDto updateCustomer(CustomerForUpdateDto customer) {
        Customer customerBeforeUpdate = customerRepo.getOne(customer.getId());
        Customer customerForUpdate = customerRepo.save(customerMapper.mapUpdateCustomerFromCustomerDto(customerBeforeUpdate, customer));
        CustomerDto customerDto = new CustomerDto();
        CustomerDto customerAfterUpdate = customerMapper.mapCustomerDtoFromCustomer(customerForUpdate, customerDto);
        return customerMapper.mapUpdateCustomerDtoToCustomerDto(customerAfterUpdate, customer);
    }

}
