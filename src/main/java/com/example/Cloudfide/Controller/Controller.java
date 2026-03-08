package com.example.Cloudfide.Controller;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.Cloudfide.Dao.CreateProduct;
import com.example.Cloudfide.Dao.ProductDao;
import com.example.Cloudfide.Entity.Product;
import com.example.Cloudfide.Response.ResponseMessage;
import com.example.Cloudfide.Service.Facade;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/shop")
@AllArgsConstructor
@ComponentScan("com.example.Cloudfide.Service")
public class Controller {
    private Facade facade;
    // LIST
    @GetMapping("/findAll")
    public List<ProductDao> list() {
        return facade.findAll();
    }

    // CREATE
    @PostMapping("/createProduct")
    public ResponseEntity<ResponseMessage> create(@Valid@RequestBody CreateProduct product) {
        facade.createProduct(product);
        return new ResponseEntity<>(new ResponseMessage("New Product Added"), HttpStatus.CREATED);
    }

    // UPDATE
    @PutMapping("/updateProduct/{id}")
    public void update(@PathVariable @Positive(message = "Id must be positive") Long id, @Valid @RequestBody CreateProduct createProduct) {
         facade.update(id, createProduct);
    }

    // DELETE
    @DeleteMapping("/deleteProduct/{id}")
    public void delete(@PathVariable  @Positive(message = "Id must be greater than 0") Long id) {
        facade.delete(id);
    }

//     // FILTER
//     @GetMapping("/filterByProducers/{producerName}")
//     public List<Item> filter(
//             @PathVariable String  producerName,
//             @RequestParam(required = false) String category
//     ) {
//         return facade.filter(name, category);
//     }
// }
}
