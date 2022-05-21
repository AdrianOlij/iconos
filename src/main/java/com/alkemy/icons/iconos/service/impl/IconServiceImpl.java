package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.mapper.ContinentMapper;
import com.alkemy.icons.iconos.mapper.IconMapper;
import com.alkemy.icons.iconos.repository.ContinentRepository;
import com.alkemy.icons.iconos.repository.IconRepository;

public class IconServiceImpl {

    private final IconMapper iconMapper;
    private final IconRepository iconRepository;

    public IconServiceImpl(IconMapper iconMapper, IconRepository iconRepository) {
        this.iconMapper = iconMapper;
        this.iconRepository = iconRepository;
    }

    public void delete(Long id){
        this.iconRepository.deleteById(id);
    }
}
