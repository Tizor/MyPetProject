package application.dto.customer;


import application.dto.FinalOrderDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.xml.bind.annotation.*;
import java.util.Collection;
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
    private Collection<FinalOrderDto> customerOrders;
}








