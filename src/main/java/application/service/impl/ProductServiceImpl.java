package application.service.impl;

import application.dao.ProductRepo;
import application.entity.Product;
import application.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Transactional
    public Collection<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Transactional
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Transactional
    public Optional<Product> findProductById(Long id) {
        return productRepo.findById(id);
    }
}
