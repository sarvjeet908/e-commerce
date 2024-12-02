package com.example.productts.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProduct extends BaseModel{

    private String title;
    private String description;
    private double price;
    private  String image;
    private String category;
    private FakeStoreRating rating;
}
