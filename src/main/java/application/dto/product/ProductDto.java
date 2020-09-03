package application.dto.product;

import application.dto.cart.CartDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Product", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private Double productPrice;
    private Date createDate;
    private Collection<CartDto> cartDto;

}
