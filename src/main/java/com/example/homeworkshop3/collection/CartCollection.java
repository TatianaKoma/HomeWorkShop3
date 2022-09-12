package com.example.homeworkshop3.collection;

import com.example.homeworkshop3.model.Cart;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CartCollection {
    public Set<Cart> carts = new HashSet<>();
}
