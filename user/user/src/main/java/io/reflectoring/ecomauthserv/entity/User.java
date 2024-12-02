package io.reflectoring.ecomauthserv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="ecom_user")
public class User extends BaseModel{
    private String name;
    private String emailId;
    private String passWord;  // encoded format
    @ManyToMany
    private List<Role> roles;
    private String token;

}
