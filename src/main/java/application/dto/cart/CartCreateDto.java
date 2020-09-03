package application.dto.cart;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Cart", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class CartCreateDto {

    private Double price;
    private Long quanity;
    private Long amount;
}
