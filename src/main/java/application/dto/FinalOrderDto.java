package application.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Final_order", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class FinalOrderDto {

    private UUID id;
    private UUID customerId;
    private UUID cartId;
    private double totalPrice;

}
