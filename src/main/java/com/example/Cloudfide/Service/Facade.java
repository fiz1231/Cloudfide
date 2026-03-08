package com.example.Cloudfide.Service;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.Cloudfide.Dao.CreateProduct;
import com.example.Cloudfide.Dao.ProductDao;
import com.example.Cloudfide.Entity.Product;
import com.example.Cloudfide.Mapper.DataMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@ComponentScan("package com.example.Cloudfide.Service")
public class Facade {
    private final Getter getter;
    private final Creator creator;
    private final Deleter deleter;
    private final Updater updater;
    public List<ProductDao> findAll() {
    
        return getter.findAll();
    }
    public Product createProduct(CreateProduct product) {
        return creator.createProduct(product);
    }
    public void update(Long id, CreateProduct newProduct) {
        updater.updateProduct(id, newProduct);
    }
    public void delete(Long id) {
        deleter.deleteProduct(id);
    }
    public List<Item> filter(String name, String category) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }
}
