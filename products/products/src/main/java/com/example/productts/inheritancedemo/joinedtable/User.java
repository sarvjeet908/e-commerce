package com.example.productts.inheritancedemo.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy =InheritanceType.JOINED)
@Entity(name="jit_user")
public class User {
    @Id
    private Long id;
    private String name;
    private String userName;
    private String passWord;

}
