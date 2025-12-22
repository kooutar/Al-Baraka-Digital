package com.kaoutar.AlBarakaDigital.service.interfaces;

import com.kaoutar.AlBarakaDigital.dto.CreateOperationDTO;
import com.kaoutar.AlBarakaDigital.dto.OprerationDto;

import java.util.List;

public interface OperationServiceInterface {

    OprerationDto create(CreateOperationDTO dto);

    OprerationDto update(Long id, CreateOperationDTO dto);

    void delete(Long id);

    OprerationDto getById(Long id);

    List<OprerationDto> getAll();
}
