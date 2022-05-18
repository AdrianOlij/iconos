package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.entities.ContinentEntity;
import com.alkemy.icons.iconos.mapper.ContinentMapper;
import com.alkemy.icons.iconos.repository.ContinentRepository;
import com.alkemy.icons.iconos.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentMapper continentMapper;

    @Autowired
    private ContinentRepository continentRepository;

    @PostMapping
    public ContinentDTO save(ContinentDTO dto){

        ContinentEntity entity = continentMapper.continentDTO2Entity(dto);
        continentRepository.save(entity);
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }
}
