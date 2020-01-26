package application.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer", namespace = "http://application.dto")
@Data
@RequiredArgsConstructor
public class CustomerCreateDto {

    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String address;
}
