package com.example.productts.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String name;
    private String description;
    private double price;
    private  String image;
    //Since Category is not primitive add mapping
    // 1 product  :  1 category
    // m product  :  1 category
    @ManyToOne(cascade = {CascadeType.PERSIST})//,fetch = FetchType.LAZY)
    private Category category;
}
