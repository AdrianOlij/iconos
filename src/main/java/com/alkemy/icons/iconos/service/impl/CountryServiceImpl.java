package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import com.alkemy.icons.iconos.mapper.CountryMapper;
import com.alkemy.icons.iconos.repository.CountryRepository;
import com.alkemy.icons.iconos.service.CountryService;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    private final IconService iconService;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository, IconService iconService) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
        this.iconService = iconService;
    }

    @Transactional
    @Override
    public List<CountryBasicDTO> getAllBasicCountries() {
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2BasicDTOList(entities);
    }

    @Transactional
    @Override
    public List<CountryDTO> getAllCountries(){
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2DTOList(entities, false);
    }

    @Transactional
    @Override
    public CountryDTO save(CountryDTO countryDTO){
        CountryEntity entity = this.countryMapper.countryDTO2Entity(countryDTO, false);
        CountryEntity saveEntity = this.countryRepository.save(entity);
        return this.countryMapper.countryEntity2DTO(saveEntity, false);
    }

    @Transactional
    @Override
    public CountryEntity getEntityById(Long idCountry) {
        return this.countryRepository.getById(idCountry);
    }

    @Transactional
    @Override
    public CountryDTO getACountry(Long id) {
        return this.countryMapper.countryEntity2DTO(countryRepository.getById(id), false);
    }

    @Transactional
    @Override
    public void addIcon(Long id, Long idIcon) {
        CountryEntity countryEntity = this.countryRepository.getById(id);
        countryEntity.getIcons().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        countryEntity.addIcon(iconEntity);
        this.countryRepository.save(countryEntity);
    }

    @Transactional
    @Override
    public void removeIcon(Long id, Long idIcon) {
        CountryEntity countryEntity = this.countryRepository.getById(id);
        countryEntity.getIcons().size();
        IconEntity iconEntity = this.iconService.getEntityById(idIcon);
        countryEntity.removeIcon(iconEntity);
        this.countryRepository.save(countryEntity);

    }


}
