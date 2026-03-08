package com.example.Cloudfide.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.Cloudfide.Entity.Product;

@org.springframework.stereotype.Repository
public interface DataRepository extends Repository<Product,Long>  {
    @Query(value = "SELECT p.* FROM products p JOIN producents pr ON p.producentid = pr.id", nativeQuery = true)
    List<Product> findAll ();

    Product save(Product insertRow);

    @Modifying
    @Transactional
    @Query(value = "update products set name = :name,producentid = :producentid,attributes = cast(:attributes as jsonb) where id = :id",nativeQuery=true)
    void editRow(@Param("id")Long id, @Param("name")String name,@Param("producentid")Long producentid,@Param("attributes") String attributes);

    void deleteById(Long id);
    
    
}
