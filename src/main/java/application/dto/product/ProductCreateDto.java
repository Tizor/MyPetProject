package application.dto.product;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Product", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class ProductCreateDto {

    private Double productPrice;
}
