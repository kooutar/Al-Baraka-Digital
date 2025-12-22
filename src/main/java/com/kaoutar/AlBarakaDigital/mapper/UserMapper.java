package com.kaoutar.AlBarakaDigital.mapper;

import com.kaoutar.AlBarakaDigital.dto.CreateUserDTO;
import com.kaoutar.AlBarakaDigital.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "role", target = "role") // role enum → String
    CreateUserDTO userToCreateUserDTO(User user);

    // Si tu veux mapper dans l’autre sens :
    @Mapping(target = "role", source = "role")
    User createUserDTOToUser(CreateUserDTO dto);
}
