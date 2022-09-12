package com.example.homeworkshop3.service;

import com.example.homeworkshop3.dto.ProductCreationDto;
import com.example.homeworkshop3.dto.ProductDto;
import com.example.homeworkshop3.model.Product;

import java.util.Set;

public interface ProductService {

    ProductDto createProduct(ProductCreationDto productCreationDTO);

    ProductDto getProductById(Integer id);

    Set<Product> getProducts();

    ProductDto updateProductById(Integer id, ProductCreationDto productCreationDTO);

    void deleteProductById(Integer id);
}
