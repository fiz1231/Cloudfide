package com.example.Cloudfide.Service;

import org.springframework.stereotype.Service;

import com.example.Cloudfide.Dao.CreateProduct;
import com.example.Cloudfide.Entity.Product;
import com.example.Cloudfide.Mapper.DataMapper;
import com.example.Cloudfide.Repository.DataRepository;
import com.example.Cloudfide.Repository.ProducentsRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class Creator {

    private final DataRepository repository;
    private final ProducentsRepository producentsRepository;
    @Transactional
    public Product createProduct(CreateProduct product){
        Product saver = DataMapper.mapCreateProductToProduct(product,producentsRepository.findById(product.getProducentid()).get());
        return repository.save(saver);
    }
}
