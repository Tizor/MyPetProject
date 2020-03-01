package application.dto;

import application.entity.FinalOrder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Set;
import java.util.UUID;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class CustomerDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String address;
    private Set<FinalOrder> customerOrders;
}








