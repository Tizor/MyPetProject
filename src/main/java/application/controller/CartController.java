package application.controller;

import application.entity.Cart;
import application.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Cart> getAllProducts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cart> getProductById(@PathVariable Long id) {
        return cartService.findCartById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Long id){
        cartService.deleteCart(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Cart cart) {
        cartService.updateCart(cart);
    }

}
