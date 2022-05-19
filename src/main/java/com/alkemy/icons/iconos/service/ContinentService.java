package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.ContinentDTO;

import java.util.List;

public interface ContinentService {

    ContinentDTO save(ContinentDTO dto);

    List<ContinentDTO> getAllContinents();
}
