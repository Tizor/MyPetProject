package application.service;

import application.dto.FinalOrderDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@WebService(serviceName = "FinalOrderService", targetNamespace = "http://soap-online-shop.com")
public interface FinalOrderService {

    @WebMethod(operationName = "getAllOrders")
    @WebResult(name = "listOfOrders")
    Collection<FinalOrderDto> getAllOrders();

    @WebMethod(operationName = "getOrderById")
    @WebResult(name = "orderById")
    FinalOrderDto getOrderById(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "deleteOrder")
    void deleteOrder(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "createOrder")
    void createOrder(@WebParam(name = "order") FinalOrderDto order);
}
