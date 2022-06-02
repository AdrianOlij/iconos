package com.alkemy.icons.iconos.controller;


import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/basic")
    public ResponseEntity<List<CountryBasicDTO>> getAllBasicCountries(){
        List<CountryBasicDTO> countries = this.countryService.getAllBasicCountries();
        return ResponseEntity.ok().body(countries);
    }

/*
    @GetMapping({"/detail"})
    public ResponseEntity<List<CountryDTO>> getAllCountries(){
        List<CountryDTO> countryDTOS = this.countryService.getAllCountries();
        return ResponseEntity.ok().body(countryDTOS);
    }
*/

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getACountry(@PathVariable Long id){
        CountryDTO getACountry = this.countryService.getACountry(id);
        return ResponseEntity.ok().body(getACountry);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country){
        CountryDTO saveCountry = this.countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCountry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> edit(@PathVariable Long id, @RequestBody CountryDTO countryDTO){
        CountryDTO editCountry = this.countryService.edit(id, countryDTO);
        return ResponseEntity.ok().body(editCountry);
    }

    @PostMapping("/{id}/icon/{idIcon}")
    public ResponseEntity<Void> addIcon(@PathVariable Long id, @PathVariable Long idIcon){
        this.countryService.addIcon(id, idIcon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/icon/{idIcon}")
    public ResponseEntity<Void> removeIcon(@PathVariable Long id, @PathVariable Long idIcon){
        this.countryService.removeIcon(id, idIcon);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> sDelete(@PathVariable Long id){
        this.countryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getCountriesDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Set<Long> continent,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<CountryDTO> countries = this.countryService.getByFilters(name, continent, order);
        return ResponseEntity.ok(countries);
    }
}
