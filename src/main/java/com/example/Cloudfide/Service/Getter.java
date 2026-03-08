package com.example.Cloudfide.Service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.Cloudfide.Dao.ProductDao;
import com.example.Cloudfide.Entity.Product;
import com.example.Cloudfide.Mapper.DataMapper;
import com.example.Cloudfide.Repository.DataRepository;

import lombok.AllArgsConstructor;

@Service

@ComponentScan("com.example.Cloudfide.Repository")
@AllArgsConstructor
public class Getter {
    private final DataRepository repository;
    
    public List<ProductDao> findAll(){
        return repository.findAll().stream().map(x->DataMapper.mapProductToProductDao(x)).toList();
    }

    
}
