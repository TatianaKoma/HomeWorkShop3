package com.example.homeworkshop3.collection;

import com.example.homeworkshop3.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductCollection {
    public Set<Product> products = new HashSet<>();
}
