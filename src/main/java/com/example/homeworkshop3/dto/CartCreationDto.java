package com.example.homeworkshop3.dto;

import com.example.homeworkshop3.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartCreationDto {

    @NotNull(message = "Id person cannot be null")
    private Integer personId;

    @NotNull(message = "List of products cannot be null")
    private List<Product> products;
}
