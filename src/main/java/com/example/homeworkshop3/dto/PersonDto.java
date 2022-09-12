package com.example.homeworkshop3.dto;

import com.example.homeworkshop3.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PersonDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Set<Cart> carts;
}
