package application.implementation;

import application.dao.CustomerRepo;
import application.dao.FinalOrderRepo;
import application.entity.Customer;
import application.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustServiceImpl implements CustService {

    private final CustomerRepo customerRepo;
    private final FinalOrderRepo orderRepo;

    @Transactional
    public Collection<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Transactional
    public Customer getCustomerById(Long id) {
        Optional<Customer> g = customerRepo.findById(id);
//        g.get().setOrders(orderRepo.getChildNotes(id));
        return g.get();
    }
}
