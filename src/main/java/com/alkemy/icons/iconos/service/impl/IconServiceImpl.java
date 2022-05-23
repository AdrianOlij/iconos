package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.ContinentEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import com.alkemy.icons.iconos.mapper.IconMapper;
import com.alkemy.icons.iconos.repository.IconRepository;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IconServiceImpl implements IconService {

    private final IconMapper iconMapper;
    private final IconRepository iconRepository;

    public IconServiceImpl(IconMapper iconMapper, IconRepository iconRepository) {
        this.iconMapper = iconMapper;
        this.iconRepository = iconRepository;
    }

    public IconDTO save(IconDTO dto) {
        IconEntity entity = this.iconMapper.iconDTO2Entity(dto); // Lo convierto en Entity
        IconEntity entitySaved = this.iconRepository.save(entity); // Lo guardo
        IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false); // Lo convierto a DTO
        return result;
    }

    public void delete(Long id) {
        this.iconRepository.deleteById(id);
    }

    public List<IconBasicDTO> getAllBasicIcons() {
        List<IconEntity> entities = this.iconRepository.findAll();
        return this.iconMapper.iconEntitySet2BasicDTOList(entities);
    }

    public List<IconDTO> getAllIcons() {
        return this.iconRepository.findAll().stream()
                .map(iconEntity -> this.iconMapper.iconEntity2DTO(iconEntity, false))
                .collect(Collectors.toList());
    }
}
