package com.example.homeworkshop3.service;

import com.example.homeworkshop3.dto.CartCreationDto;
import com.example.homeworkshop3.dto.CartDto;
import com.example.homeworkshop3.model.Cart;

import java.util.Set;

public interface CartService {

    CartDto createCart(CartCreationDto cartCreationDTO);

    Set<Cart> getCarts();

    CartDto getCartById(Integer id);

    CartDto addProductToCartById(Integer id, Integer productId);

    void deleteCartById(Integer id);
}
