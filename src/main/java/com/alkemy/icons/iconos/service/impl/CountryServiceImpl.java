package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import com.alkemy.icons.iconos.mapper.CountryMapper;
import com.alkemy.icons.iconos.repository.CountryRepository;
import com.alkemy.icons.iconos.repository.IconRepository;
import com.alkemy.icons.iconos.service.CountryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    private final IconRepository iconRepository;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository,
                              IconRepository iconRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
        this.iconRepository = iconRepository;
    }

    @Transactional
    @Override
    public List<CountryBasicDTO> getAllBasicCountries() {
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2BasicDTOList(entities);
    }

    @Transactional
    @Override
    public List<CountryDTO> getAllCountries() {
        List<CountryEntity> entities = this.countryRepository.findAll();
        return this.countryMapper.countryEntityList2DTOList(entities, false);
    }

    @Transactional
    @Override
    public CountryDTO save(CountryDTO countryDTO) {
        CountryEntity entity = this.countryMapper.countryDTO2Entity(countryDTO, false);
        CountryEntity saveEntity = this.countryRepository.save(entity);
        return this.countryMapper.countryEntity2DTO(saveEntity, false);
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
        countryEntity.getIcons().size();
        IconEntity iconEntity = this.iconRepository.getById(idIcon);
        countryEntity.addIcon(iconEntity);
        this.countryRepository.save(countryEntity);
    }

    @Transactional
    @Override
    public void removeIcon(Long id, Long idIcon) {
        CountryEntity countryEntity = this.countryRepository.getById(id);
        countryEntity.getIcons().size();
        IconEntity iconEntity = this.iconRepository.getById(idIcon);
        countryEntity.removeIcon(iconEntity);
        this.countryRepository.save(countryEntity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.countryRepository.deleteById(id);
    }
}
