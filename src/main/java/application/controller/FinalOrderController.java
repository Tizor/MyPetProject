package application.controller;

import application.dto.FinalOrderCreateDto;
import application.entity.FinalOrder;
import application.service.FinalOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class FinalOrderController {

    private final FinalOrderService finalOrderService;

    public FinalOrderController(FinalOrderService finalOrderService) {
        this.finalOrderService = finalOrderService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<FinalOrder> getAllCustomers() {
        return finalOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<FinalOrder> getCustomerById(@PathVariable Long id) {
        return finalOrderService.findOrderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody FinalOrderCreateDto customer) {
        finalOrderService.createOrder(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        finalOrderService.deleteOrder(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody FinalOrder customer) {
        finalOrderService.updateOrder(customer);
    }
}
