package com.example.Cloudfide.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Cloudfide.Entity.Producent;

public interface ProducentsRepository extends JpaRepository<Producent, Long> {
    
}
