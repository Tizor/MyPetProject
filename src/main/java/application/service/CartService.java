package application.service;

import application.dto.cart.CartCreateDto;
import application.dto.cart.CartDto;
import application.dto.customer.CustomerDto;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.UUID;

@WebService(serviceName = "CartService", targetNamespace = "http://soap-online-shop.com")
public interface CartService {
    @WebMethod(operationName = "getAllCarts")
    @WebResult(name = "listOfCarts")
    Collection<CartDto> getAllCarts();

    @WebMethod(operationName = "getCartById")
    @WebResult(name = "cartById")
    CartDto getCartById(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "updateCustomer")
    @WebResult(name = "customerAfterUpdate")
    CartDto addProductInTheCart(@WebParam(name = "cart") CartDto cartDto);

    @WebMethod(operationName = "deleteCustomer")
    void deleteCart(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "createCart")
    void createCart(@WebParam(name = "cart") CartCreateDto cartCreateDto);
}
