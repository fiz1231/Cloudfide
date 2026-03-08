package com.example.Cloudfide.Mapper;

import com.example.Cloudfide.Dao.CreateProduct;
import com.example.Cloudfide.Dao.ProductDao;
import com.example.Cloudfide.Entity.Producent;
import com.example.Cloudfide.Entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataMapper {
    static public ProductDao mapProductToProductDao(Product product){
        return new ProductDao(product.getId(), product.getName(), product.getProducent().getName(),product.getAttributes());
    }

    static public Product mapCreateProductToProduct(CreateProduct createProduct,Producent producent){
        Product product =new Product();
        product.setName(createProduct.getName());
        product.setProducent(producent);
        product.setAttributes(createProduct.getAttributes());
        return product;
    }

    
}
