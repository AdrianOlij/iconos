package com.alkemy.icons.iconos.controller;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.service.ContinentService;
import com.alkemy.icons.iconos.service.impl.ContinentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("continents")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @PostMapping
    public ResponseEntity<ContinentDTO> save(@RequestBody ContinentDTO continent){      //setteamos la creacion de continent del tipo ContinentDTO
        ContinentDTO saveContinent = continentService.save(continent);                  //save continent
        return ResponseEntity.status(HttpStatus.CREATED).body(saveContinent);           //201, continente guardado
    }
}
