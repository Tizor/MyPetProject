package application.mapper;

import application.dto.customer.CustomerDto;
import application.dto.product.ProductCreateDto;
import application.dto.product.ProductDto;
import application.entity.Customer;
import application.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProductMapper {

    public void mapProductFromProductCreateDto(Product product, ProductCreateDto productCreateDto) {
        product.setProductPrice(productCreateDto.getProductPrice());
    }

    public Product mapProductFromProductDto(Product product, ProductDto productDto) {
        product.setProductPrice(productDto.getProductPrice());
        return product;
    }

    public ProductDto mapProductDtoFromProduct(Product product, ProductDto productDto) {
        productDto.setId(product.getId());
        productDto.setProductPrice(product.getProductPrice());
        return productDto;
    }

    public Collection<ProductDto> mapListOfProductsToListOfProductsDto (Collection<Product> productList){
        Collection<ProductDto> productsDtoList = new ArrayList<>();
        for (Product productFromList : productList ){
            ProductDto productDto = new ProductDto();
            ProductDto productTransform = mapProductDtoFromProduct(productFromList, productDto);
            productsDtoList.add(productTransform);
        }
        return productsDtoList;
    }

}
