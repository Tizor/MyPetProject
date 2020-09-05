package application.dto;

import application.entity.FinalOrder;
import lombok.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateDto {

    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String address;
    private Collection<FinalOrder> orders;

}
