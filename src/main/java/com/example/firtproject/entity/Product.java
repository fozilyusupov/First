package com.example.firtproject.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String productname;
    @Column
    private int productprice;
}
