package application.service.impl;

import application.dao.CartRepo;
import application.dao.ProductRepo;
import application.entity.Cart;
import application.service.CartService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class CartImpl implements CartService {

    private final CartRepo cartRepo;

    public CartImpl(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @Transactional
    public Collection<Cart> getAllCarts() {
        return cartRepo.findAll();
    }

    @Transactional
    public Cart updateCart(Cart cart) {
        return cartRepo.save(cart);
    }

    @Transactional
    public void deleteCart(Long id) {
        cartRepo.deleteById(id);
    }

    @Transactional
    public Optional<Cart> findCartById(Long id) {
        return cartRepo.getChildNotes(id);
    }
}
