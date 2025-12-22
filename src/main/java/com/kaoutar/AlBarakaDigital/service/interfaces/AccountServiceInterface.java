package com.kaoutar.AlBarakaDigital.service.interfaces;

import com.kaoutar.AlBarakaDigital.dto.AccountDetailsDTO;
import com.kaoutar.AlBarakaDigital.dto.AccountDto;

import java.util.List;

public interface AccountServiceInterface {

    AccountDto create(AccountDto dto);

    AccountDto update(Long id, AccountDto dto);

    void delete(Long id);

    AccountDto getById(Long id);

    List<AccountDto> getAll();

    AccountDetailsDTO getDetails(Long id);
}
