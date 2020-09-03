package application.service;

import application.entity.Customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;

@WebService(serviceName = "CustService", targetNamespace = "http://soap-online-shop.com")
public interface CustService {

    @WebMethod(operationName = "getAllCustomers")
    @WebResult(name = "listOfCustomers")
    Collection<Customer> getAllCustomers();

    @WebMethod(operationName = "getCustomerById")
    @WebResult(name = "customerById")
    Customer getCustomerById(@WebParam(name = "id") Long id);

}
