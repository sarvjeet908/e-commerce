package io.reflectoring.ecomauthserv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "role_Name")
public class Role extends BaseModel{
    private  String roleName;
    private String description;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
