package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ContinentService {

    @PostMapping
    public ContinentDTO save(ContinentDTO dto){
        // TODO: guardar continente
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }
}
