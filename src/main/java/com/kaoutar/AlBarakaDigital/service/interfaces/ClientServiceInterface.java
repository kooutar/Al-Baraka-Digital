package com.kaoutar.AlBarakaDigital.service.interfaces;

import com.kaoutar.AlBarakaDigital.dto.ClientDto;

import java.util.List;

public interface ClientServiceInterface {

    ClientDto create(ClientDto dto);

    ClientDto update(Long id, ClientDto dto);

    void delete(Long id);

    ClientDto getById(Long id);

    List<ClientDto> getAll();
}
