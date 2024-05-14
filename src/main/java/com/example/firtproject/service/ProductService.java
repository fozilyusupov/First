package com.example.firtproject.service;

import com.example.firtproject.dto.ProductForm;
import com.example.firtproject.entity.Product;
import com.example.firtproject.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ArrayList<Product> api(){
        return productRepository.findAll();
    }
    public Product add(@RequestBody ProductForm form){
        Product product=form.toEntity();

        return productRepository.save(product);
    }
    public Product update(@PathVariable Long id, @RequestBody ProductForm form){
        Product product=form.toEntity();
        Product target=productRepository.findById(id).orElse(null);
        if(target!=null || product.getId()==target.getId()){
            return productRepository.save(product);
        }
        return null ;
    }
    public Product delete(@PathVariable Long id){
        Product product=productRepository.findById(id).orElse(null);
        productRepository.delete(product);
        return product;
    }
}
