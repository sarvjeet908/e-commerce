package com.example.productts.inheritancedemo.singletable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="sgl_mentor")
@DiscriminatorValue("1")
public class Mentor extends User {
    private String avgRating;
    private String company;
}
