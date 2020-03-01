package application.implementation;

import application.dao.FinalOrderRepo;
import application.dto.FinalOrderDto;
import application.entity.FinalOrder;
import application.mapper.FinalOrderMapper;
import application.service.FinalOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FinalOrderServiceImpl implements FinalOrderService {

    private final FinalOrderRepo orderRepo;
    private final FinalOrderMapper orderMapper;

    @Transactional
    public Collection<FinalOrderDto> getAllOrders() {
        Collection<FinalOrder> ordersFromDBList = orderRepo.findAll();
        return orderMapper.mapListOfOrdersToListOfOrdersDto(ordersFromDBList);
    }

    @Transactional
    public void createOrder(FinalOrderDto orderDto) {
        FinalOrder newOrder = new FinalOrder();
        orderMapper.mapOrderDtoFromOrder(newOrder, orderDto);
        orderRepo.save(newOrder);
    }

    @Transactional
    public FinalOrderDto getOrderById(UUID id) {
        FinalOrder orderFromDB = orderRepo.getOne(id);
        FinalOrderDto orderDto = new FinalOrderDto();
        return orderMapper.mapOrderDtoFromOrder(orderFromDB, orderDto);
    }

    @Transactional
    public void deleteOrder(UUID id) {
        orderRepo.deleteById(id);
    }

}
