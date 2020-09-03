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
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FinalOrderServiceImpl implements FinalOrderService {

    private final FinalOrderRepo orderRepo;
    private final FinalOrderMapper orderMapper;

    @Transactional
    public Collection<FinalOrder> getAllOrders() {
        return orderRepo.findAll();
    }

    @Transactional
    public FinalOrder getOrderById(Long id) {
        return orderRepo.getOne(id);
    }

    @Transactional
    public void createOrder(FinalOrderDto orderDto) {
        FinalOrder newOrder = new FinalOrder();
        orderMapper.mapOrderDtoFromOrder(newOrder, orderDto);
        orderRepo.save(newOrder);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }

}
