package com.example.homeworkshop3.mapper;

import com.example.homeworkshop3.dto.ProductCreationDto;
import com.example.homeworkshop3.dto.ProductDto;
import com.example.homeworkshop3.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductCreationDto productCreationDTO) {
        Product product = new Product();
        product.setName(productCreationDTO.getName());
        product.setPrice(productCreationDTO.getPrice());
        return product;
    }

    public ProductDto toProductDTO(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }
}
