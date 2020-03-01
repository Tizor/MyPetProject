package application.mapper;

import application.dto.CustomerDto;
import application.entity.Customer;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    public void mapCustomerFromCustomerCreateDto(Customer customer, CustomerDto customerCreateDto) {
        customer.setEmail(customerCreateDto.getEmail());
        customer.setAddress(customerCreateDto.getAddress());
        customer.setAge(customerCreateDto.getAge());
        customer.setFirstName(customerCreateDto.getFirstName());
        customer.setLastName(customerCreateDto.getLastName());
        customer.setCustomerOrders(null);
    }

    public Customer mapCustomerFromCustomerDto(Customer customer, CustomerDto customerDto) {
        customer.setId(customerDto.getId());
        customer.setLastName(customerDto.getLastName());
        customer.setFirstName(customerDto.getFirstName());
        customer.setAge(customerDto.getAge());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        customer.setCustomerOrders(null);
        return customer;
    }

    public CustomerDto mapCustomerDtoFromCustomer(Customer customer, CustomerDto customerDto) {
        customerDto.setId(customer.getId());
        customerDto.setLastName(customer.getLastName());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setAge(customer.getAge());
        customerDto.setAddress(customer.getAddress());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    public List<CustomerDto> mapListOfCustomersToListOfCustomersDto (List<Customer> customerList){
         List<CustomerDto> customersDtoList = new ArrayList<>();

         for (Customer customerFromList : customerList ){
             CustomerDto customerDto = new CustomerDto();
             CustomerDto customerTransform = mapCustomerDtoFromCustomer(customerFromList, customerDto);
             customersDtoList.add(customerTransform);
         }
         return customersDtoList;
    }

}
