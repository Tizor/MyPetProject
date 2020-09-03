package application.mapper;

import application.dto.customer.CustomerCreateDto;
import application.dto.customer.CustomerDto;
import application.dto.customer.CustomerForUpdateDto;
import application.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final FinalOrderMapper orderMapper;

    public void mapCustomerFromCustomerCreateDto(Customer customer, CustomerCreateDto customerCreateDto) {
        customer.setEmail(customerCreateDto.getEmail());
        customer.setAddress(customerCreateDto.getAddress());
        customer.setAge(customerCreateDto.getAge());
        customer.setFirstName(customerCreateDto.getFirstName());
        customer.setLastName(customerCreateDto.getLastName());
//        customer.setOrder(null);
    }

    public Customer mapCustomerFromCustomerDto(Customer customer, CustomerDto customerDto) {
        customer.setId(customerDto.getId());
        customer.setLastName(customerDto.getLastName());
        customer.setFirstName(customerDto.getFirstName());
        customer.setAge(customerDto.getAge());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    public Customer mapUpdateCustomerFromCustomerDto(Customer customer, CustomerForUpdateDto customerDto) {
        customer.setId(customerDto.getId());
        customer.setLastName(customerDto.getLastName());
        customer.setFirstName(customerDto.getFirstName());
        customer.setAge(customerDto.getAge());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        return customer;
    }

    public CustomerDto mapCustomerDtoFromCustomer(Customer customer, CustomerDto customerDto) {
        customerDto.setId(customer.getId());
        customerDto.setLastName(customer.getLastName());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setAge(customer.getAge());
        customerDto.setAddress(customer.getAddress());
        customerDto.setEmail(customer.getEmail());
        customerDto.setCustomerOrders((orderMapper.mapListOfOrdersToListOfOrdersDto(null)));
        return customerDto;
    }

    public CustomerDto mapUpdateCustomerDtoToCustomerDto(CustomerDto customerDto, CustomerForUpdateDto customer) {
        customerDto.setId(customer.getId());
        customerDto.setLastName(customer.getLastName());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setAge(customer.getAge());
        customerDto.setAddress(customer.getAddress());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    public Collection<CustomerDto> mapListOfCustomersToListOfCustomersDto (List<Customer> customerList){
        Collection<CustomerDto> customersDtoList = new ArrayList<>();

         for (Customer customerFromList : customerList ){
             CustomerDto customerDto = new CustomerDto();
             CustomerDto customerTransform = mapCustomerDtoFromCustomer(customerFromList, customerDto);
             customersDtoList.add(customerTransform);
         }
         return customersDtoList;
    }

}
