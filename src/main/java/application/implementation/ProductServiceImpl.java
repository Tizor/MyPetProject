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
        productMapper.mapProductFromProductCreateDto(newProduct, productCreateDto);
        productRepo.save(newProduct);
    }

    @Transactional
    public Collection<ProductDto> getAllProducts() {
        List<Product> productsFromDBList = productRepo.findAll();
        return productMapper.mapListOfProductsToListOfProductsDto(productsFromDBList)  ;
    }

    @Transactional
    public ProductDto getProductById(UUID id) {
        Product productFromDB = productRepo.getOne(id);
        ProductDto productDto = new ProductDto();
        return productMapper.mapProductDtoFromProduct(productFromDB, productDto);
    }

    @Transactional
    public ProductDto updateProduct(ProductDto product) {
        Product productBeforeUpdate = productRepo.getOne(product.getId());
        productRepo.save(productMapper.mapProductFromProductDto(productBeforeUpdate, product));
        Product productFromDB = productRepo.getOne(product.getId());
        ProductDto productDto = new ProductDto();
        return productMapper.mapProductDtoFromProduct(productFromDB, productDto);
    }

    @Transactional
    public void deleteProduct(UUID id) {
        productRepo.deleteById(id);
    }

}
