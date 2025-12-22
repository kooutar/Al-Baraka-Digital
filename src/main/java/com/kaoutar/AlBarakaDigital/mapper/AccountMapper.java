package com.kaoutar.AlBarakaDigital.mapper;

import com.kaoutar.AlBarakaDigital.dto.AccountDto;
import com.kaoutar.AlBarakaDigital.model.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "ownerId", source = "owner.id")
    AccountDto toDto(Account account);

    @InheritInverseConfiguration
    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "simpleOperations", ignore = true)
    @Mapping(target = "outgoingTransfers", ignore = true)
    @Mapping(target = "incomingTransfers", ignore = true)
    Account toEntity(AccountDto dto);
}
