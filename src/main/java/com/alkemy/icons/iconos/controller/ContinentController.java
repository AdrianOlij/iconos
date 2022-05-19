package com.alkemy.icons.iconos.controller;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.service.ContinentService;
import com.alkemy.icons.iconos.service.impl.ContinentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continents")
public class ContinentController {

    @Autowired
    private ContinentService continentService; //Inyectamos la dependencia de la capa service

    @GetMapping
    public ResponseEntity<List<ContinentDTO>> getAll(){ //este getAll es un metodo del JpaRepository
        List<ContinentDTO> continents = continentService.getAllContinents(); // implementamos el getAllCotinents del service
        return ResponseEntity.ok().body(continents);
        /* Request para mostrar lista de todos los continentes */
    }

    @PostMapping
    public ResponseEntity<ContinentDTO> save(@RequestBody ContinentDTO continent) { //setteamos la creacion de continent del tipo ContinentDTO
        ContinentDTO saveContinent = continentService.save(continent);              //creamos el continente en formato DTO
        return ResponseEntity.status(HttpStatus.CREATED).body(saveContinent);       //201, confirmacion del request
    }
}
