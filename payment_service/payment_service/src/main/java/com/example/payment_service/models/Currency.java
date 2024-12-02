package com.example.payment_service.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Currency extends BaseModel{
    private String currencyTag;
    private String currencyName;
    private String country;

}
