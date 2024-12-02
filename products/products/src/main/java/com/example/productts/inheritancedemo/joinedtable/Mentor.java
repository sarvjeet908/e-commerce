package com.example.productts.inheritancedemo.joinedtable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jit_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    private String avgRating;
    private String company;
}
