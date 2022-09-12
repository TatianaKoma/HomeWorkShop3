package com.example.homeworkshop3.service.impl;

import com.example.homeworkshop3.collection.ProductCollection;
import com.example.homeworkshop3.dto.ProductCreationDto;
import com.example.homeworkshop3.dto.ProductDto;
import com.example.homeworkshop3.exception.NotFoundException;
import com.example.homeworkshop3.mapper.ProductMapper;
import com.example.homeworkshop3.model.Product;
import com.example.homeworkshop3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_NOT_FOUND = "Product with id %s was not found";

    private final ProductCollection productCollection;
    private final ProductMapper mapper;

    @Override
    public ProductDto createProduct(ProductCreationDto productCreationDTO) {
        Product newProduct = mapper.toProduct(productCreationDTO);
        if (productCollection.products.isEmpty()) {
            newProduct.setId(1);
        } else {
            Integer id = productCollection.products.size() + 1;
            newProduct.setId(id);
        }
        productCollection.products.add(newProduct);
        return mapper.toProductDTO(newProduct);
    }

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productCollection.products.stream()
                .filter(person -> Objects.equals(person.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(PRODUCT_NOT_FOUND, id)));
        return mapper.toProductDTO(product);
    }

    @Override
    public Set<Product> getProducts() {
        return productCollection.products;
    }

    @Override
    public ProductDto updateProductById(Integer id, ProductCreationDto productCreationDTO) {
        Product productForUpdate = productCollection.products.stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(PRODUCT_NOT_FOUND, id)));
        productForUpdate.setName(productCreationDTO.getName());
        productForUpdate.setPrice(productCreationDTO.getPrice());
        productCollection.products.add(productForUpdate);
        return mapper.toProductDTO(productForUpdate);
    }

    @Override
    public void deleteProductById(Integer id) {
        Product productForDelete = productCollection.products.stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(PRODUCT_NOT_FOUND, id)));
        productCollection.products.remove(productForDelete);
    }
}
