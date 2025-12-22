package com.kaoutar.AlBarakaDigital.mapper;

import com.kaoutar.AlBarakaDigital.dto.ClientDto;
import com.kaoutar.AlBarakaDigital.enums.RoleUser;
import com.kaoutar.AlBarakaDigital.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AccountMapper.class},  imports = RoleUser.class)
public interface ClientMapper {

    @Mapping(target = "role", expression = "java(client.getRole().name())")
    ClientDto toDto(Client client);

    @Mapping(target = "role", expression = "java(RoleUser.valueOf(dto.getRole()))")
    @Mapping(target = "account", ignore = true)
    Client toEntity(ClientDto dto);
}
