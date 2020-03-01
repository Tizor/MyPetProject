package application.mapper;

import application.dto.FinalOrderDto;
import application.entity.FinalOrder;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.HashSet;

@Component
public class FinalOrderMapper {

//    public void mapOrderFromCustomerCreateDto(Customer customer, CustomerDto customerCreateDto) {
//        customer.setEmail(customerCreateDto.getEmail());
//        customer.setAddress(customerCreateDto.getAddress());
//        customer.setAge(customerCreateDto.getAge());
//        customer.setFirstName(customerCreateDto.getFirstName());
//        customer.setLastName(customerCreateDto.getLastName());
//        customer.setCustomerOrders(null);
//    }

    public FinalOrder mapOrderFromOrderDto(FinalOrder finalOrder, FinalOrderDto orderDto) {
        finalOrder.setId(orderDto.getId());
        finalOrder.setCartId(orderDto.getCartId());
        finalOrder.setCustomerId(orderDto.getCustomerId());
        finalOrder.setTotalPrice(orderDto.getTotalPrice());
        return finalOrder;
    }

    public FinalOrderDto mapOrderDtoFromOrder(FinalOrder finalOrder, FinalOrderDto orderDto) {
        orderDto.setId(finalOrder.getId());
        orderDto.setCartId(finalOrder.getCartId());
        orderDto.setCustomerId(finalOrder.getCustomerId());
        orderDto.setTotalPrice(finalOrder.getTotalPrice());
        return orderDto;
    }

    public Collection<FinalOrderDto> mapListOfOrdersToListOfOrdersDto (Collection<FinalOrder> ordersList){
        Collection<FinalOrderDto> ordersDtoList = new HashSet<>();

        for (FinalOrder orderFromList : ordersList ){
            FinalOrderDto orderDto = new FinalOrderDto();
            FinalOrderDto orderTransform = mapOrderDtoFromOrder(orderFromList, orderDto);
            ordersDtoList.add(orderTransform);
        }
        return ordersDtoList;
    }

}
