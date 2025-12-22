package com.kaoutar.AlBarakaDigital.service.interfaces;

import com.kaoutar.AlBarakaDigital.dto.DoucumentDto;

import java.util.List;

public interface DocumentServiceInterface {

    DoucumentDto create(DoucumentDto dto);

    DoucumentDto update(Long id, DoucumentDto dto);

    void delete(Long id);

    DoucumentDto getById(Long id);

    List<DoucumentDto> getAll();
}
