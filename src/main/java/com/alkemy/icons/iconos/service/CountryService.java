package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;

import java.util.List;

public interface CountryService {

    List<CountryBasicDTO> getAllBasicCountries();

    List<CountryDTO> getAllCountries();

    CountryDTO save(CountryDTO countryDTO);

    CountryEntity getEntityById(Long idCountry);

}
