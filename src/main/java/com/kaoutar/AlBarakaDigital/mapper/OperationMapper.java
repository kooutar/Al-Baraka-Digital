package com.kaoutar.AlBarakaDigital.mapper;

import com.kaoutar.AlBarakaDigital.dto.CreateOperationDTO;
import com.kaoutar.AlBarakaDigital.dto.OprerationDto;
import com.kaoutar.AlBarakaDigital.enums.OperationStatus;
import com.kaoutar.AlBarakaDigital.enums.OperationType;
import com.kaoutar.AlBarakaDigital.model.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {OperationType.class, OperationStatus.class})
public interface OperationMapper {


    /* =======================
       Entity -> DTO (RETURN)
       ======================= */
    @Mapping(target = "type", expression = "java(operation.getType().name())")
    @Mapping(target = "status", expression = "java(operation.getStatus().name())")
    @Mapping(target = "accountId", source = "account.id")
    @Mapping(target = "accountSourceId", source = "accountSource.id")
    @Mapping(target = "accountDestinationId", source = "accountDestination.id")
    OprerationDto toDto(Operation operation);

    /* =======================
       Create DTO -> Entity
       ======================= */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", expression = "java(OperationType.valueOf(dto.getType()))")
    @Mapping(target = "status", expression = "java(OperationStatus.PENDING)")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "validatedAt", ignore = true)
    @Mapping(target = "executedAt", ignore = true)

    // Relations injectées dans le service
    @Mapping(target = "account", ignore = true)
    @Mapping(target = "accountSource", ignore = true)
    @Mapping(target = "accountDestination", ignore = true)
    Operation toEntity(CreateOperationDTO dto);
}

