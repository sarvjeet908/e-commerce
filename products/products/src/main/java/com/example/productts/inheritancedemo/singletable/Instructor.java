package com.example.productts.inheritancedemo.singletable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity(name = "sgl_instructor")
@DiscriminatorValue("2")
public class Instructor extends User {
    private  String specialization;
}
