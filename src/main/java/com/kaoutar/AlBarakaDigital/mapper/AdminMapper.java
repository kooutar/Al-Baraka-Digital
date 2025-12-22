package com.kaoutar.AlBarakaDigital.mapper;

import com.kaoutar.AlBarakaDigital.dto.AdminDto;
import com.kaoutar.AlBarakaDigital.enums.RoleUser;
import com.kaoutar.AlBarakaDigital.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Mapping(target = "role", expression = "java(admin.getRole().name())")
    AdminDto toDto(Admin admin);

    @Mapping(target = "role", expression = "java(RoleUser.valueOf(dto.getRole()))")
    Admin toEntity(AdminDto dto);
}


