package com.example.Cloudfide.Dao;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




public record ProductDao(
    Long id,
    String name,
    String producentName,
    Map<String,String> atrubutes
) {}
