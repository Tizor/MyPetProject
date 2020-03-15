package application.implementation;

import application.dao.CartRepo;
import application.dto.cart.CartCreateDto;
import application.dto.cart.CartDto;
import application.dto.customer.CustomerDto;
import application.entity.Cart;
import application.entity.Customer;
import application.mapper.CartMapper;
import application.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;
    private final CartMapper cartMapper;

    @Transactional
    public Collection<CartDto> getAllCarts() {
        List<Cart> cartFromDBList = cartRepo.findAll();
        return cartMapper.mapListOfCartsToListOfCartsDto(cartFromDBList);
    }

    @Transactional
    public CartDto getCartById(UUID id) {
        Cart cartFromDB = cartRepo.getOne(id);
        CartDto cartDto = new CartDto();
        return cartMapper.mapCartDtoFromCart(cartFromDB, cartDto);
    }

    @Transactional
    public CartDto addProductInTheCart(CartDto cartDto) {
        Cart cartBeforeUpdate = cartRepo.getOne(cartDto.getId());
        Cart cartForUpdate = cartRepo.save(cartMapper.mapCartFromCartDto(cartBeforeUpdate, cartDto));
        CartDto cartDtoAfterUpdate = cartMapper.mapCartDtoFromCart(cartForUpdate, new CartDto());
        return cartDtoAfterUpdate;
    }

    @Transactional
    public void deleteCart(UUID id) {

    }

    @Transactional
    public void createCart(CartCreateDto cartCreateDto) {

    }
}
