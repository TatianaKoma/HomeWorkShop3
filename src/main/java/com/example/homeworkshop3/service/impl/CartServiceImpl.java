package com.example.homeworkshop3.service.impl;

import com.example.homeworkshop3.collection.CartCollection;
import com.example.homeworkshop3.collection.ProductCollection;
import com.example.homeworkshop3.dto.CartCreationDto;
import com.example.homeworkshop3.dto.CartDto;
import com.example.homeworkshop3.exception.NotFoundException;
import com.example.homeworkshop3.mapper.CartMapper;
import com.example.homeworkshop3.mapper.ProductMapper;
import com.example.homeworkshop3.model.Cart;
import com.example.homeworkshop3.model.Product;
import com.example.homeworkshop3.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private static final String CART_NOT_FOUND = "Cart with id %s was not found";
    private static final String PRODUCT_NOT_FOUND = " This product doesn't exist in the shop";

    private final CartCollection cartCollection;
    private final ProductCollection productCollection;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    @Override
    public CartDto createCart(CartCreationDto cartCreationDTO) {
        Cart newCart = cartMapper.toCart(cartCreationDTO);
        if (cartCollection.carts.isEmpty()) {
            newCart.setId(1);
        } else {
            Integer id = cartCollection.carts.size() + 1;
            newCart.setId(id);
        }
        newCart.setSum(new BigDecimal(0));

        cartCollection.carts.add(newCart);
        return cartMapper.toCartDTO(newCart);
    }

    @Override
    public Set<Cart> getCarts() {
        return new HashSet<>(cartCollection.carts);
    }

    @Override
    public CartDto getCartById(Integer id) {
        Cart cart = cartCollection.carts.stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(CART_NOT_FOUND, id)));
        return cartMapper.toCartDTO(cart);
    }

    @Override
    public CartDto addProductToCartById(Integer id, Integer productId) {
        Cart cartForUpdate = cartCollection.carts.stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(CART_NOT_FOUND, id)));
        List<Product> cartProducts = cartForUpdate.getProducts();
        Product newProduct = productCollection.products.stream()
                .filter(p -> p.getId().equals(productId))
                .findAny().orElseThrow(() -> new NotFoundException(String.format(PRODUCT_NOT_FOUND)));
        cartProducts.add(newProduct);
        BigDecimal sum = cartProducts.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        cartForUpdate.setProducts(cartProducts);
        cartForUpdate.setSum(sum);
        cartCollection.carts.add(cartForUpdate);
        return cartMapper.toCartDTO(cartForUpdate);
    }

    @Override
    public void deleteCartById(Integer id) {
        Cart cartForDelete = cartCollection.carts.stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(CART_NOT_FOUND, id)));
        cartCollection.carts.remove(cartForDelete);
    }
}
