package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.mapper.CountryMapper;
import com.alkemy.icons.iconos.repository.CountryRepository;
import com.alkemy.icons.iconos.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }

    public List<CountryBasicDTO> getAllBasicCountries() {
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2BasicDTOList(entities);
    }

    public List<CountryDTO> getAllCountries(){
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2DTOList(entities, false);
    }

    public CountryDTO save(CountryDTO countryDTO){
        CountryEntity entity = this.countryMapper.countryDTO2Entity(countryDTO, false);
        CountryEntity saveEntity = this.countryRepository.save(entity);
        return this.countryMapper.countryEntity2DTO(saveEntity, false);
    }
}
