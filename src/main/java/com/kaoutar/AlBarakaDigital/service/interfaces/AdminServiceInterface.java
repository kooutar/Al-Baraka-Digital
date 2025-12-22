package com.kaoutar.AlBarakaDigital.service.interfaces;

import com.kaoutar.AlBarakaDigital.dto.AdminDto;

import java.util.List;

public interface AdminServiceInterface {

    AdminDto create(AdminDto dto);

    AdminDto update(Long id, AdminDto dto);

    void delete(Long id);

    AdminDto getById(Long id);

    List<AdminDto> getAll();
}
