package com.example.homeworkshop3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer id;
    private Integer personId;
    private List<Product> products;
    private BigDecimal sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id.equals(cart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
