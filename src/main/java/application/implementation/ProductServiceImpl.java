package application.implementation;

import application.dao.ProductRepo;
import application.dto.product.ProductCreateDto;
import application.dto.product.ProductDto;
import application.entity.Product;
import application.mapper.ProductMapper;
import application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Transactional
    public void addProduct(ProductCreateDto productCreateDto) {
        Product newProduct = new Product();
        productRepo.save(newProduct);
    }

    @Transactional
    public Collection<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Transactional
    public Product getProductById(Long id) {
        return productRepo.getOne(id);
    }

    @Transactional
    public void updateProduct(Product product) {
        Product productBeforeUpdate = productRepo.getOne(product.getId());
        productRepo.save(productBeforeUpdate);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

}
