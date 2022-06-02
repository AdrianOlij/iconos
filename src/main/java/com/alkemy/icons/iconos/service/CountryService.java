package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;

import java.util.List;
import java.util.Set;

public interface CountryService {

    List<CountryBasicDTO> getAllBasicCountries();

/*    List<CountryDTO> getAllCountries();*/

    CountryDTO save(CountryDTO countryDTO);

    CountryDTO getACountry(Long id);

    void addIcon(Long id, Long idIcon);

    void removeIcon(Long id, Long idIcon);

    void delete(Long id);

    CountryDTO edit(Long id, CountryDTO countryDTO);

    List<CountryDTO> getByFilters(String name, Set<Long> idContinent, String order);
}
