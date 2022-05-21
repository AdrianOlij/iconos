package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.IconDTO;

public interface IconService {

    IconDTO save(IconDTO);

    void delete(Long id);
}
