package io.reflectoring.ecomauthserv.dto;

import io.reflectoring.ecomauthserv.entity.Role;
import io.reflectoring.ecomauthserv.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String email;
    private List<RoleResponseDTO> roles;
    private String token;

    public static UserResponseDto from(User user){
        if(user == null)
            return null;
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.name = user.getName();
        userResponseDto.email = user.getEmailId();
        userResponseDto.token = user.getToken();
        userResponseDto.roles = new ArrayList<>();
        //convert it to lambda stream
        for(Role role : user.getRoles()){
            RoleResponseDTO responseDTO = new RoleResponseDTO();
            responseDTO.setDesc(role.getDescription());
            responseDTO.setRole(role.getRoleName());
            userResponseDto.roles.add(responseDTO);
        }
        return userResponseDto;
    }

}
