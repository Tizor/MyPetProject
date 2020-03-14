package application.implementation;

import application.dao.CartRepo;
import application.dto.cart.CartCreateDto;
import application.dto.cart.CartDto;
import application.dto.customer.CustomerDto;
import application.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;

    @Transactional
    public Collection<CartDto> getAllCarts() {
        return null;
    }

    @Transactional
    public CustomerDto getCartById(UUID id) {
        return null;
    }

    @Transactional
    public CustomerDto addProductInTheCart(CartDto cartDto) {
        return null;
    }

    @Transactional
    public void deleteCart(UUID id) {

    }

    @Transactional
    public void createCart(CartCreateDto cartCreateDto) {

    }
}
