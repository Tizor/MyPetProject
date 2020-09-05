package application.service;

import application.dto.FinalOrderCreateDto;
import application.entity.FinalOrder;

import java.util.Collection;
import java.util.Optional;

public interface FinalOrderService {

    Collection<FinalOrder> getAllOrders();
    void createOrder(FinalOrderCreateDto finOrder);
    void updateOrder(FinalOrder finOrder);
    void deleteOrder(Long id);
    Optional<FinalOrder> findOrderById(Long id);
}
