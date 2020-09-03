package application.implementation;

import application.dao.CartRepo;
import application.dto.cart.CartCreateDto;
import application.dto.cart.CartDto;
import application.dto.customer.CustomerDto;
import application.dto.product.ProductDto;
import application.entity.Cart;
import application.entity.Customer;
import application.entity.Product;
import application.mapper.CartMapper;
import application.service.CartService;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;
    private final SessionFactory sessionFactory;

    @Transactional
    public Collection<Cart> getAllCarts() {
        return cartRepo.findAll();
    }

    @Transactional
    public Cart getCartById(Long id) {
        return cartRepo.getOne(id);
    }

    @Transactional
    public Cart addProductInTheCart(Cart cartDto) {
        Cart cartBeforeUpdate = cartRepo.getOne(cartDto.getId());
        return cartRepo.save(cartBeforeUpdate);
    }

    @Transactional
    public List<Product> getCartByCustomerId(Long id) {
        return sessionFactory
                .getCurrentSession()
                .createQuery(" select p from Product p where p.id in (1)", Product.class)
                .getResultList();
    }

    @Transactional
    public void deleteCart(Long id) {

    }

    @Transactional
    public void createCart(CartCreateDto cartCreateDto) {

    }
}
