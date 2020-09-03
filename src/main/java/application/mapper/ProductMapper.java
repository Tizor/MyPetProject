package application.mapper;

import application.dto.customer.CustomerDto;
import application.dto.product.ProductCreateDto;
import application.dto.product.ProductDto;
import application.entity.Customer;
import application.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CartMapper cartMapper;

    public void mapProductFromProductCreateDto(Product product, ProductCreateDto productCreateDto) {
        product.setName(productCreateDto.getName());
        product.setCreateDate(productCreateDto.getCreateDate());
        product.setPrice(productCreateDto.getProductPrice());
    }

    public Product mapProductFromProductDto(Product product, ProductDto productDto) {
        product.setName(productDto.getName());
        product.setCreateDate(productDto.getCreateDate());
        product.setPrice(productDto.getProductPrice());
        return product;
    }

    public ProductDto mapProductDtoFromProduct(Product product, ProductDto productDto) {
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setProductPrice(product.getPrice());
        productDto.setCreateDate(productDto.getCreateDate());
        productDto.setCartDto(cartMapper.mapListOfCartsToListOfCartsDto(product.getCart()));
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
