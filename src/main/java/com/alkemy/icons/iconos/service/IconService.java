package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.IconDTO;

public interface IconService {

    IconDTO save(IconDTO iconDTO);

    void delete(Long id);
}
