package com.alkemy.icons.iconos.controller;


import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<CountryBasicDTO>> getAllBasicCountries(){
        List<CountryBasicDTO> countries = this.countryService.getAllBasicCountries();
        return ResponseEntity.ok().body(countries);
    }

    @GetMapping({"/detail"})
    public ResponseEntity<List<CountryDTO>> getAllCountries(){
        List<CountryDTO> countryDTOS = this.countryService.getAllCountries();
        return ResponseEntity.ok().body(countryDTOS);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country){
        CountryDTO saveCountry = this.countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCountry);
    }
}
