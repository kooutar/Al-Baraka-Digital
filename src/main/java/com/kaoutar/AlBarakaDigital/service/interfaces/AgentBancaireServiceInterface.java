package com.kaoutar.AlBarakaDigital.service.interfaces;

import com.kaoutar.AlBarakaDigital.dto.AgentBancaireDto;

import java.util.List;

public interface AgentBancaireServiceInterface {

    AgentBancaireDto create(AgentBancaireDto dto);

    AgentBancaireDto update(Long id, AgentBancaireDto dto);

    void delete(Long id);

    AgentBancaireDto getById(Long id);

    List<AgentBancaireDto> getAll();
}
