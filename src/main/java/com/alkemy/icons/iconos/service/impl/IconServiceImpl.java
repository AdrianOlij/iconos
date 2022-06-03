package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.dto.IconFiltersDTO;
import com.alkemy.icons.iconos.entities.IconEntity;
import com.alkemy.icons.iconos.exception.NotFound;
import com.alkemy.icons.iconos.mapper.IconMapper;
import com.alkemy.icons.iconos.repository.IconRepository;
import com.alkemy.icons.iconos.repository.specification.IconSpecification;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class IconServiceImpl implements IconService {

    private final IconMapper iconMapper;
    private final IconRepository iconRepository;
    private final IconSpecification iconSpecification;
    //private final CountryRepository countryRepository;

    public IconServiceImpl(IconMapper iconMapper, IconRepository iconRepository, IconSpecification iconSpecification/*, CountryRepository countryRepository*/) {
        this.iconMapper = iconMapper;
        this.iconRepository = iconRepository;
        this.iconSpecification = iconSpecification;
        /*this.countryRepository = countryRepository;*/
    }

    @Transactional
    @Override
    public IconDTO save(IconDTO iconDTO) {
        IconEntity iconEntity = this.iconMapper.iconDTO2Entity(iconDTO, false);
        IconEntity entitySaved = this.iconRepository.save(iconEntity); // Lo guardo
        return this.iconMapper.iconEntity2DTO(entitySaved, false);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<IconEntity> entity = iconRepository.findById(id);
        if (!entity.isPresent()) {
            throw new NotFound("No se encontro el ID del Icono");
        }
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
        if (!entity.isPresent()) {
            throw new NotFound("No se encontro el ID del Icono");
        }
        this.iconMapper.iconChangeValues(entity.get(), iconDTO);
        IconEntity iconEntitySaved = this.iconRepository.save(entity.get());
        return this.iconMapper.iconEntity2DTO(iconEntitySaved, false);
    }

    @Transactional
    @Override
    public List<IconDTO> getAllIcons() {
        return this.iconRepository.findAll().stream()
                .map(iconEntity -> this.iconMapper.iconEntity2DTO(iconEntity, true))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public IconDTO getAnIcon(Long id) {
        Optional<IconEntity> iconEntity = this.iconRepository.findById(id);
        if (!iconEntity.isPresent()){
            throw new NotFound("No se encontro el ID del icono");
        }
        IconDTO iconDTO = this.iconMapper.iconEntity2DTO(iconEntity.get(), true);
        return iconDTO;
    }

    @Transactional
    @Override
    public List<IconDTO> getByFilters(String name, String date, Set<Long> countries, String order) {
        IconFiltersDTO iconFiltersDTO = new IconFiltersDTO(name, date, countries, order);
        List<IconEntity> iconEntities = this.iconRepository.findAll(this.iconSpecification.getByFilters(iconFiltersDTO));
        List<IconDTO> iconDTOS = this.iconMapper.iconEntityList2DTOList(iconEntities, true);
        return iconDTOS;
    }

/*  Grisado por si hay escalado mas adelante
    @Transactional
    @Override
    public void addCountry(Long iconId, Long idCountry) {
        IconEntity iconEntity = this.iconRepository.getById(iconId);
        CountryEntity countryEntity = this.countryRepository.getById(idCountry);
        iconEntity.addCountry(countryEntity);
        this.iconRepository.save(iconEntity);

    }

    @Transactional
    @Override
    public void removeCountry(Long iconId, Long idCountry) {
        IconEntity iconEntity = this.iconRepository.getById(iconId);
        CountryEntity countryEntity = this.countryRepository.getById(idCountry);
        iconEntity.removeCountry(countryEntity);
        this.iconRepository.save(iconEntity);
    }
*/
}