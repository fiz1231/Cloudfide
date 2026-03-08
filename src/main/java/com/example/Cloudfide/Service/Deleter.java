package com.example.Cloudfide.Service;

import org.springframework.stereotype.Service;

import com.example.Cloudfide.Repository.DataRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Deleter {
    private final DataRepository repository;

    public void deleteProduct(Long id){
        repository.deleteById(id);
    }
}
