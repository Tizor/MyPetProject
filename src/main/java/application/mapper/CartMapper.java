package application.mapper;

import application.dto.cart.CartCreateDto;
import application.dto.cart.CartDto;
import application.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CartMapper {

    public void mapCartFromCartCreateDto(Cart cart, CartCreateDto cartCreateDto) {
        cart.setAmount(cartCreateDto.getAmount());
        cart.setPrice(cartCreateDto.getPrice());
        cart.setQuanity(cartCreateDto.getQuanity());
        cart.setProduct(null);
    }

    public Cart mapCartFromCartDto(Cart cart, CartDto cartDto) {
        cart.setId(cartDto.getId());
        cart.setAmount(cartDto.getAmount());
        cart.setPrice(cartDto.getPrice());
        cart.setQuanity(cartDto.getQuanity());
        return cart;
    }

    public CartDto mapCartDtoFromCart(Cart cart, CartDto cartDto) {
        cartDto.setId(cart.getId());
        cartDto.setAmount(cart.getAmount());
        cartDto.setPrice(cart.getPrice());
        cartDto.setQuanity(cart.getQuanity());
//        cartDto.setProductInCart(productMapper.mapListOfProductsToListOfProductsDto(cart.getProduct()));
        return cartDto;
    }

    public Collection<CartDto> mapListOfCartsToListOfCartsDto (Collection<Cart> cartList){
        Collection<CartDto> cartDtoList = new ArrayList<>();
        for (Cart cartFromList : cartList ){
            CartDto cartDto = new CartDto();
            CartDto cartTransform = mapCartDtoFromCart(cartFromList, cartDto);
            cartDtoList.add(cartTransform);
        }
        return cartDtoList;
    }

}
