package com.example.firtproject.dto;

import com.example.firtproject.entity.Product;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
    private Long id;
    private String productname;
    private int productprice;

    public Product toEntity(){return new Product(id,productname,productprice);}

}
