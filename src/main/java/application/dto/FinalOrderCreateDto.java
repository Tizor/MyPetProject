package application.dto;

import application.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalOrderCreateDto {

    private Double totalPrice;
    private Customer customer;
}
