package com.example.firtproject.Controller;

import com.example.firtproject.dto.ProductForm;
import com.example.firtproject.entity.Product;
import com.example.firtproject.repository.ProductRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@Slf4j
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/")
    public String index(){
        return "Product/homepage";
    }
    @GetMapping("/product/new")
    public String newproduct(){
        return "Product/new";
    }
    @PostMapping("/product/create")
    public String add(ProductForm form){
        Product product=form.toEntity();
        productRepository.save(product);

        return "redirect:/product/show";
    }
    @GetMapping("/product/show")
    public String show(Model model){
        ArrayList<Product> products=productRepository.findAll();
        model.addAttribute("product",products);
        return "Product/show";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Model model){
        Product products=productRepository.findById(id).orElse(null);
        model.addAttribute("product",products);
        return "Product/product";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable Long id, Model model){


        Product products=productRepository.findById(id).orElse(null);
        model.addAttribute("product",products);
        return "Product/edit";
    }
    @PostMapping("/product/edit")
    public String update( ProductForm form){
        System.out.println("Postttttttt");

        log.info(form.toString());

        Product product=form.toEntity();

        Product terget=productRepository.findById(product.getId()).orElse(null);

        if(terget!=null) {
            productRepository.save(product);
        }
        return "redirect:/product/show";
    }
@GetMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id){

    System.out.println("Deletteeeeee");
        Product product=productRepository.findById(id).orElse(null);
        if (product!=null){
            productRepository.delete(product);
        }
    return "redirect:/product/show";
}

}
