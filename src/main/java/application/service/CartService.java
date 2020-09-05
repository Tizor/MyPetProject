package application.service;

import application.entity.Cart;

import java.util.Collection;
import java.util.Optional;

public interface CartService {

    Collection<Cart> getAllCarts();
    Cart updateCart(Cart cart);
    void deleteCart(Long id);
    Optional<Cart> findCartById(Long id);
}
