package application.service.impl;

import application.dao.FinalOrderRepo;
import application.dto.FinalOrderCreateDto;
import application.entity.FinalOrder;
import application.service.FinalOrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class FinalOrderServiceImpl implements FinalOrderService {

    private final FinalOrderRepo finalOrderRepo;

    public FinalOrderServiceImpl(FinalOrderRepo finalOrderRepo) {
        this.finalOrderRepo = finalOrderRepo;
    }

    @Transactional
    public Collection<FinalOrder> getAllOrders() {
        return finalOrderRepo.findAll();
    }

    @Transactional
    public void createOrder(FinalOrderCreateDto finOrder) {
    }

    @Transactional
    public void updateOrder(@RequestBody FinalOrder finOrder) {
        finalOrderRepo.save(finOrder);
    }

    @Transactional
    public void deleteOrder(Long id) {
        finalOrderRepo.deleteById(id);
    }

    @Transactional
    public Optional<FinalOrder> findOrderById(Long id) {
        return finalOrderRepo.findById(id);
    }
}
