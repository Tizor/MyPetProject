package application.service;

import application.dto.product.ProductCreateDto;
import application.dto.product.ProductDto;
import application.entity.Product;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Collection;
import java.util.UUID;

@WebService(serviceName = "ProductService", targetNamespace = "http://soap-online-shop.com")
public interface ProductService {
    @WebMethod(operationName = "getAllProducts")
    @WebResult(name = "listOfProducts")
    Collection<Product> getAllProducts();

    @WebMethod(operationName = "getProductById")
    @WebResult(name = "productById")
    Product getProductById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "updateProduct")
    @WebResult(name = "productAfterUpdate")
    void updateProduct(@WebParam(name = "product") Product product);

    @WebMethod(operationName = "deleteProduct")
    void deleteProduct(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "addProduct")
    void addProduct(@WebParam(name = "product") ProductCreateDto product);
}
