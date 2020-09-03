package application.service;

import application.dto.cart.CartCreateDto;
import application.dto.cart.CartDto;
import application.dto.customer.CustomerDto;
import application.dto.product.ProductDto;
import application.entity.Cart;
import application.entity.Product;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@WebService(serviceName = "CartService", targetNamespace = "http://soap-online-shop.com")
public interface CartService {
    @WebMethod(operationName = "getAllCarts")
    @WebResult(name = "listOfCarts")
    Collection<Cart> getAllCarts();

    @WebMethod(operationName = "getCartById")
    @WebResult(name = "cartById")
    Cart getCartById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "updateCustomer")
    @WebResult(name = "customerAfterUpdate")
    Cart addProductInTheCart(@WebParam(name = "cart") Cart cart);

    @WebMethod(operationName = "deleteCustomer")
    void deleteCart(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "createCart")
    void createCart(@WebParam(name = "cart") CartCreateDto cartCreateDto);

    @WebMethod(operationName = "getCartByCustomerId")
    @WebResult(name = "cartByCustomerId")
    List<Product> getCartByCustomerId(@WebParam(name = "id") Long id);
}
