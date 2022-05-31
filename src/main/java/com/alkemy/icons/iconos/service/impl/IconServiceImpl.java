package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import com.alkemy.icons.iconos.exception.NotFound;
import com.alkemy.icons.iconos.mapper.IconMapper;
import com.alkemy.icons.iconos.repository.CountryRepository;
import com.alkemy.icons.iconos.repository.IconRepository;
import com.alkemy.icons.iconos.service.CountryService;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class IconServiceImpl implements IconService{

    private final IconMapper iconMapper;
    private final IconRepository iconRepository;
    private final CountryRepository countryRepository;

    public IconServiceImpl(IconMapper iconMapper, IconRepository iconRepository, CountryRepository countryRepository) {
        this.iconMapper = iconMapper;
        this.iconRepository = iconRepository;
        this.countryRepository = countryRepository;
    }

    @Transactional
    @Override
    public IconDTO save(IconDTO dto) {
        IconEntity entity = this.iconMapper.iconDTO2Entity(dto, false);
        IconEntity entitySaved = this.iconRepository.save(entity); // Lo guardo
        return this.iconMapper.iconEntity2DTO(entitySaved, false);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }

    @Transactional
    @Override
    public List<IconBasicDTO> getAllBasicIcons() {
        List<IconEntity> entities = this.iconRepository.findAll();
        return this.iconMapper.iconEntityList2BasicDTOList(entities);
    }

    @Transactional
    @Override
    public IconDTO edit(Long id, IconDTO iconDTO) {
        Optional<IconEntity> entity = iconRepository.findById(id);
        if(!entity.isPresent()){
            throw new NotFound("No se encontro el Icono");
        }
        IconEntity iconEntity = this.iconMapper.iconDTO2Entity(iconDTO, false);
        IconEntity iconSaved = this.iconRepository.save(iconEntity);
        return this.iconMapper.iconEntity2DTO(iconEntity, false);

    }

    @Transactional
    @Override
    public List<IconDTO> getAllIcons() {
        return this.iconRepository.findAll().stream()
                .map(iconEntity -> this.iconMapper.iconEntity2DTO(iconEntity, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public IconDTO getAnIcon(Long id) {
        return this.iconMapper.iconEntity2DTO(iconRepository.getById(id), false);
    }

    @Transactional
    @Override
    public void addCountry(Long iconId, Long idCountry) {
        IconEntity iconEntity = this.iconRepository.getById(iconId);
        iconEntity.getCountries().size();
        CountryEntity countryEntity = this.countryRepository.getById(idCountry);
        iconEntity.addCountry(countryEntity);
        this.iconRepository.save(iconEntity);

    }

    @Transactional
    @Override
    public void removeCountry(Long iconId, Long idCountry) {
        IconEntity iconEntity = this.iconRepository.getById(iconId);
        iconEntity.getCountries().size();
        CountryEntity countryEntity = this.countryRepository.getById(idCountry);
        iconEntity.removeCountry(countryEntity);
        this.iconRepository.save(iconEntity);
    }
}
