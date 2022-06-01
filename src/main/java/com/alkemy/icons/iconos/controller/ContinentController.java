package com.alkemy.icons.iconos.controller;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.service.ContinentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continents")
public class ContinentController {

    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) { //Inyectamos la dependencia de la capa service
        this.continentService = continentService;
    }

    // Request para mostrar lista de todos los continentes
    @GetMapping
    //este getAll es un metodo del JpaRepository
    public ResponseEntity<List<ContinentDTO>> getAll() {
        // implementamos el getAllCotinents del service
        List<ContinentDTO> continents = this.continentService.getAllContinents();
        return ResponseEntity.ok().body(continents);

    }

    @PostMapping
    //setteamos la creacion de continent del tipo ContinentDTO
    public ResponseEntity<ContinentDTO> save(@RequestBody ContinentDTO continent) {
        //creamos el continente en formato DTO
        ContinentDTO saveContinent = this.continentService.save(continent);
        //201, confirmacion del request
        return ResponseEntity.status(HttpStatus.CREATED).body(saveContinent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContinentDTO> getAContinent(@PathVariable Long id){
        ContinentDTO getAContinent = this.continentService.getAContinent(id);
        return ResponseEntity.ok().body(getAContinent);
    }
}
