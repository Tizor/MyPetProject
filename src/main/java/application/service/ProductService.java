package application.service;

import application.dto.product.ProductCreateDto;
import application.dto.product.ProductDto;
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
    Collection<ProductDto> getAllProducts();

    @WebMethod(operationName = "getProductById")
    @WebResult(name = "productById")
    ProductDto getProductById(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "updateProduct")
    @WebResult(name = "productAfterUpdate")
    ProductDto updateProduct(@WebParam(name = "product") ProductDto product);

    @WebMethod(operationName = "deleteProduct")
    void deleteProduct(@WebParam(name = "id") UUID id);

    @WebMethod(operationName = "addCustomer")
    void addProduct(@WebParam(name = "product") ProductCreateDto product);
}
