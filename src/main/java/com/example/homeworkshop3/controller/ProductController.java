package com.example.homeworkshop3.controller;

import com.example.homeworkshop3.dto.ProductCreationDto;
import com.example.homeworkshop3.dto.ProductDto;
import com.example.homeworkshop3.model.Product;
import com.example.homeworkshop3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@Validated
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody ProductCreationDto productCreationDTO) {
        return productService.createProduct(productCreationDTO);
    }

    @GetMapping
    public Set<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = "/{id}")
    public ProductDto getCartById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping(value = "/{id}")
    public ProductDto updateProduct(@PathVariable("id") Integer id,
                                    @Valid
                                    @RequestBody ProductCreationDto productCreationDTO) {
        return productService.updateProductById(id, productCreationDTO);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        productService.deleteProductById(id);
    }
}
