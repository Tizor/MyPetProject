package application.dto.cart;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Cart", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class CartDto {

    private UUID id;
    private double totalPriceForProduct;
    private double totalPriceForCart;
    private Long productAmount;
}
