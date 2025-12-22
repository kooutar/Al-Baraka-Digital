package com.kaoutar.AlBarakaDigital.mapper;

import com.kaoutar.AlBarakaDigital.dto.AgentBancaireDto;
import com.kaoutar.AlBarakaDigital.enums.RoleUser;
import com.kaoutar.AlBarakaDigital.model.Agent_bancaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = RoleUser.class)
public interface AgentBancaireMapper {

    @Mapping(target = "role", expression = "java(agent.getRole().name())")
    AgentBancaireDto toDto(Agent_bancaire agent);

    @Mapping(target = "role", expression = "java(RoleUser.valueOf(dto.getRole()))")
    Agent_bancaire toEntity(AgentBancaireDto dto);
}