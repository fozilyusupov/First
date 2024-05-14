package com.example.firtproject.ApiController;

import com.example.firtproject.dto.ProductForm;
import com.example.firtproject.entity.Product;
import com.example.firtproject.repository.ProductRepository;
import com.example.firtproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ApiProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public ArrayList<Product> api(){
        return productService.api();
    }

    @PostMapping("/add")
    public  ResponseEntity<Product> add(@RequestBody ProductForm form){
        return (productService.add(form)!=null)?
            ResponseEntity.status(HttpStatus.OK).body(productService.add(form)):
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody ProductForm form){
        return (productService.update(id,form)!=null)?
                ResponseEntity.status(HttpStatus.OK).body(productService.update(id,form)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }
    @PostMapping("/transaction")
    public ArrayList<Product> tr(@RequestBody ArrayList<ProductForm> forms){
        ArrayList<Product> products=new ArrayList<>();
        for (ProductForm x:forms)products.add(x.toEntity());
        for (Product x:products) productRepository.save(x);
        return products;
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        return (productService.delete(id)!=null)?
                ResponseEntity.status(HttpStatus.OK).body(productService.delete(id)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); }


}




