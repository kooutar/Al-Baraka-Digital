package com.kaoutar.AlBarakaDigital.mapper;

import com.kaoutar.AlBarakaDigital.dto.DoucumentDto;
import com.kaoutar.AlBarakaDigital.model.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    @Mapping(target = "operationId", source = "operation.id")
    DoucumentDto toDto(Document document);

    @Mapping(target = "operation", ignore = true)
    Document toEntity(DoucumentDto dto);
}

