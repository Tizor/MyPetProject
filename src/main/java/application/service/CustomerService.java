package application.service;

import application.dto.CustomerCreateDto;
import application.dto.CustomerDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;
import java.util.UUID;

@WebService (serviceName = "CustomerService", targetNamespace = "http://soap-online-shop.com")
public interface CustomerService {

    @WebMethod(operationName = "getAllCustomers")
    @WebResult(name = "listOfCustomers")
    List<CustomerDto> getAllCustomers();

    @WebMethod(operationName = "getCustomerById")
    @WebResult(name = "customerById")
    CustomerDto getCustomerById(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "updateCustomer")
    @WebResult(name = "customerAfterUpdate")
    CustomerDto updateCustomer(@WebParam(name = "customer") CustomerDto customer);

    @WebMethod(operationName = "deleteCustomer")
    void deleteCustomer(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "addCustomer")
    void addCustomer(@WebParam(name = "customer") CustomerCreateDto customer);

}
