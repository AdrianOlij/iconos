package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.IconEntity;
import com.alkemy.icons.iconos.exception.NotFound;
import com.alkemy.icons.iconos.mapper.IconMapper;
import com.alkemy.icons.iconos.repository.IconRepository;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< Updated upstream
=======
import java.util.Optional;
import java.util.stream.Collectors;
>>>>>>> Stashed changes

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
        return this.iconMapper.iconEntity2DTO(entitySaved, false); // Lo convierto a DTO
    }

    public void delete(Long id){
        this.iconRepository.deleteById(id);
    }

    public List<IconBasicDTO> getAllIcons() {
        List<IconEntity> entities = this.iconRepository.findAll();
<<<<<<< Updated upstream
        List<IconBasicDTO> results = this.iconMapper.iconEntitySet2BasicDTOList(entities);
        return results;
=======
        return this.iconMapper.iconEntityList2BasicDTOList(entities);
    }

    public IconDTO edit(Long id, IconDTO iconDTO) {
        Optional<IconEntity> entity = iconRepository.findById(id);
        if(!entity.isPresent()){
            throw new NotFound("No se encontro el pais");
        }
        IconEntity iconEntity = this.iconMapper.iconDTO2Entity(iconDTO);
        IconEntity iconSaved = this.iconRepository.save(iconEntity);
        return this.iconMapper.iconEntity2DTO(iconEntity, false);

    }

    public List<IconDTO> getAllIcons() {
        return this.iconRepository.findAll().stream()
                .map(iconEntity -> this.iconMapper.iconEntity2DTO(iconEntity, false))
                .collect(Collectors.toList());
>>>>>>> Stashed changes
    }
}
