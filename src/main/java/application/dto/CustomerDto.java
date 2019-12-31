package application.dto;


import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.UUID;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer", namespace = "http://application.dto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String address;
}








