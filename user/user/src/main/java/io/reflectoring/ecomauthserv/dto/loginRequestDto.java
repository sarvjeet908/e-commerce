package io.reflectoring.ecomauthserv.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class loginRequestDto {
    private String emailId;
    private String passWord;
}
