package application.service;

import application.dto.customer.CustomerCreateDto;
import application.dto.customer.CustomerDto;
import application.dto.customer.CustomerForUpdateDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.UUID;

@WebService (serviceName = "CustomerService", targetNamespace = "http://soap-online-shop.com")
public interface CustomerService {

    @WebMethod(operationName = "getAllCustomers")
    @WebResult(name = "listOfCustomers")
    Collection<CustomerDto> getAllCustomers();

    @WebMethod(operationName = "getCustomerById")
    @WebResult(name = "customerById")
    CustomerDto getCustomerById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "updateCustomer")
    @WebResult(name = "customerAfterUpdate")
    CustomerDto updateCustomer(@WebParam(name = "customer") CustomerForUpdateDto customer);

    @WebMethod(operationName = "deleteCustomer")
    void deleteCustomer(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "addCustomer")
    void addCustomer(@WebParam(name = "customer") CustomerCreateDto customer);
}
