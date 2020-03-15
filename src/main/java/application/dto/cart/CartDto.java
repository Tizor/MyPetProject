package application.dto.cart;

import application.dto.product.ProductDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;
import java.util.UUID;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Cart", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class CartDto {

    private UUID id;
    private Double totalPriceForProduct;
    private Double totalPriceForCart;
    private Long productAmount;
    private Collection<ProductDto> productInCart;
}
