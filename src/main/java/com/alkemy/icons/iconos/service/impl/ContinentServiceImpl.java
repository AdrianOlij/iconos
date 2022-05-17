package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.service.ContinentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ContinentServiceImpl implements ContinentService {

    @PostMapping
    public ContinentDTO save(ContinentDTO dto){
        // TODO: guardar continente
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }
}
