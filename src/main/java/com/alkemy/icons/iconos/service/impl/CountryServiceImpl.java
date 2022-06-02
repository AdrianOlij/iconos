package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.*;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import com.alkemy.icons.iconos.exception.NotFound;
import com.alkemy.icons.iconos.mapper.CountryMapper;
import com.alkemy.icons.iconos.repository.CountryRepository;
import com.alkemy.icons.iconos.repository.IconRepository;
import com.alkemy.icons.iconos.repository.specification.CountrySpecification;
import com.alkemy.icons.iconos.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    private final IconRepository iconRepository;
    private final CountrySpecification countrySpecification;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository,
                              IconRepository iconRepository, CountrySpecification countrySpecification) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
        this.iconRepository = iconRepository;
        this.countrySpecification = countrySpecification;
    }

    @Transactional
    @Override
    public List<CountryBasicDTO> getAllBasicCountries() {
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2BasicDTOList(entities);
    }

/*
    @Transactional
    @Override
    public List<CountryDTO> getAllCountries() {
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2DTOList(entities, false);
    }
*/

    @Transactional
    @Override
    public CountryDTO save(CountryDTO countryDTO) {
        CountryEntity entity = this.countryMapper.countryDTO2Entity(countryDTO, false);
        CountryEntity saveEntity = this.countryRepository.save(entity);
        return this.countryMapper.countryEntity2DTO(saveEntity, false);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Transactional
    @Override
    public CountryDTO edit(Long id, CountryDTO countryDTO) {
        Optional<CountryEntity> entity = countryRepository.findById(id);
        if (!entity.isPresent()) {
            throw new NotFound("No se encontro el Pais");
        }
        this.countryMapper.countryChangeValues(entity.get(), countryDTO);
        CountryEntity countryEntitySaved = this.countryRepository.save(entity.get());
        return this.countryMapper.countryEntity2DTO(countryEntitySaved, false);
    }

    @Transactional
    @Override
    public CountryDTO getACountry(Long id) {
        return this.countryMapper.countryEntity2DTO(countryRepository.getById(id), true);
    }

    @Transactional
    @Override
    public void addIcon(Long id, Long idIcon) {
        CountryEntity countryEntity = this.countryRepository.getById(id);
        IconEntity iconEntity = this.iconRepository.getById(idIcon);
        countryEntity.addIcon(iconEntity);
        this.countryRepository.save(countryEntity);
    }

    @Transactional
    @Override
    public void removeIcon(Long id, Long idIcon) {
        CountryEntity countryEntity = this.countryRepository.getById(id);
        IconEntity iconEntity = this.iconRepository.getById(idIcon);
        countryEntity.removeIcon(iconEntity);
        this.countryRepository.save(countryEntity);
    }

    @Transactional
    @Override
    public List<CountryDTO> getByFilters(String name, Set<Long> continent, String order) {
        CountryFiltersDTO countryFiltersDTO = new CountryFiltersDTO(name, continent, order);
        List<CountryEntity> countryEntities = this.countryRepository.findAll(
                this.countrySpecification.getByFilters(countryFiltersDTO));

        List<CountryDTO> countryDTOS = this.countryMapper.countryEntityList2DTOList(countryEntities, true);
        return countryDTOS;
    }


}
