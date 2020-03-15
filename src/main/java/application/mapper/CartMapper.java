package application.mapper;

import application.dto.cart.CartCreateDto;
import application.dto.cart.CartDto;
import application.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartMapper {

    private final ProductMapper productMapper;

    public void mapCartFromCartCreateDto(Cart cart, CartCreateDto cartCreateDto) {
        cart.setProductAmount(cartCreateDto.getProductAmount());
        cart.setTotalPriceForCart(cartCreateDto.getTotalPriceForCart());
        cart.setTotalPriceForProduct(cartCreateDto.getTotalPriceForProduct());
        cart.setProductInCart(null);
    }

    public Cart mapCartFromCartDto(Cart cart, CartDto cartDto) {
        cart.setId(cartDto.getId());
        cart.setProductAmount(cartDto.getProductAmount());
        cart.setTotalPriceForCart(cartDto.getTotalPriceForCart());
        cart.setTotalPriceForProduct(cartDto.getTotalPriceForProduct());
        return cart;
    }

    public CartDto mapCartDtoFromCart(Cart cart, CartDto cartDto) {
        cartDto.setId(cart.getId());
        cartDto.setProductAmount(cart.getProductAmount());
        cartDto.setTotalPriceForCart(cart.getTotalPriceForCart());
        cartDto.setTotalPriceForProduct(cart.getTotalPriceForProduct());
        cartDto.setProductInCart(productMapper.mapListOfProductsToListOfProductsDto(cart.getProductInCart()));
        return cartDto;
    }

    public Collection<CartDto> mapListOfCartsToListOfCartsDto (List<Cart> cartList){
        Collection<CartDto> cartDtoList = new ArrayList<>();
        for (Cart cartFromList : cartList ){
            CartDto cartDto = new CartDto();
            CartDto cartTransform = mapCartDtoFromCart(cartFromList, cartDto);
            cartDtoList.add(cartTransform);
        }
        return cartDtoList;
    }

}
