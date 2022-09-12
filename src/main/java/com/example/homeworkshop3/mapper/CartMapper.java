package com.example.homeworkshop3.mapper;

import com.example.homeworkshop3.dto.CartCreationDto;
import com.example.homeworkshop3.dto.CartDto;
import com.example.homeworkshop3.model.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public Cart toCart(CartCreationDto cartCreationDTO) {
        Cart cart = new Cart();
        cart.setPersonId(cartCreationDTO.getPersonId());
        cart.setProducts(cartCreationDTO.getProducts());
        return cart;
    }

    public CartDto toCartDTO(Cart cart) {
        return new CartDto(cart.getId(), cart.getPersonId(), cart.getProducts(), cart.getSum());
    }
}
