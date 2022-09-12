package com.example.homeworkshop3.dto;

import com.example.homeworkshop3.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Integer id;
    private Integer personId;
    private List<Product> products;
    private BigDecimal sum;
}
