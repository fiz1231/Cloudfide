package com.example.Cloudfide.Dao;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateProduct {

    @NotBlank(message = "Product name cannot be empty")
    @Size(min = 2, max = 100)
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Need producent id")
    private Long producentid;

    
    private Map<String,String> attributes;
}
