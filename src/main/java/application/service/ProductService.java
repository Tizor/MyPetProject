package application.service;

import application.entity.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {

    Collection<Product> getAllProducts();
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    Optional<Product> findProductById(Long id);
}
