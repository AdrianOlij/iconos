package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.CountryBasicDTO;
import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper {

    private final IconMapper iconMapper;

    public CountryMapper(IconMapper iconMapper) {
        this.iconMapper = iconMapper;
    }

    public CountryDTO countryEntity2DTO(CountryEntity entity, boolean loadIcons) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(entity.getId());
        countryDTO.setImage(entity.getImage());
        countryDTO.setDenomination(entity.getDenomination());
        countryDTO.setPopulation(entity.getPopulation());
        countryDTO.setArea(entity.getArea());
        countryDTO.setContinentId(entity.getContinentId());
        if (loadIcons) {
            List<IconDTO> iconDTOS = this.iconMapper.iconEntityList2DTOList(entity.getIcons(), false);
            countryDTO.setIcons(iconDTOS);
        }
        return countryDTO;
    }

    public CountryEntity countryDTO2Entity(CountryDTO dto, boolean loadIcons) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setImage(dto.getImage());
        countryEntity.setDenomination(dto.getDenomination());
        countryEntity.setPopulation(dto.getPopulation());
        countryEntity.setArea(dto.getArea());
        countryEntity.setContinentId(dto.getContinentId());
        if (loadIcons) {
            List<IconEntity> iconEntities = this.iconMapper.iconDTOList2EntityList(dto.getIcons());
            countryEntity.setIcons(iconEntities);
        }
        return countryEntity;
    }

    public List<CountryDTO> countryEntityList2DTOList(List<CountryEntity> countryEntities, boolean loadIcons) {
        List<CountryDTO> countryDTOS = new ArrayList<>();
        for (CountryEntity countryEntity : countryEntities) {
            countryDTOS.add(this.countryEntity2DTO(countryEntity, loadIcons));
        }
        return countryDTOS;
    }

    public List<CountryEntity> countryDTOList2EntityList(List<CountryDTO> dtos) {
        List<CountryEntity> entities = new ArrayList<>();
        for (CountryDTO dto : dtos) {
            entities.add(this.countryDTO2Entity(dto, false));
        }
        return entities;
    }

    // Entity a Basic DTO
    public CountryBasicDTO countryEntity2BasicDTO(CountryEntity entity) {
        return new CountryBasicDTO(entity.getId(), entity.getImage(), entity.getDenomination(), entity.getPopulation());
    }

    // Entity List a Basic DTO List
    public List<CountryBasicDTO> countryEntityList2BasicDTOList(Collection<CountryEntity> entities) {
        return entities.stream()
                .map(countryEntity -> countryEntity2BasicDTO(countryEntity))
                .collect(Collectors.toList());
    }

    public void countryChangeValues(CountryEntity countryEntity, CountryDTO countryDTO) {
        countryEntity.setImage(countryDTO.getImage());
        countryEntity.setDenomination(countryDTO.getDenomination());
        countryEntity.setPopulation(countryDTO.getPopulation());
        countryEntity.setArea(countryDTO.getArea());
        countryEntity.setContinentId(countryDTO.getContinentId());
    }
}