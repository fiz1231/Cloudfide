package com.example.Cloudfide.Service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.Cloudfide.Dao.CreateProduct;
import com.example.Cloudfide.Entity.Product;
import com.example.Cloudfide.Repository.DataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@ComponentScan("com.example.Cloudfide.Repository")
public class Updater {
    private final DataRepository repository;
    
    ObjectMapper mapper = new ObjectMapper();
    
    public void updateProduct(Long id,CreateProduct product){
        try {
            repository.editRow(id, product.getName(),product.getProducentid(),
            mapper.writeValueAsString(product.getAttributes()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
