package com.example.firtproject.repository;

import com.example.firtproject.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductRepository extends CrudRepository<Product,Long> {
    @Override
    ArrayList<Product>findAll();



}
