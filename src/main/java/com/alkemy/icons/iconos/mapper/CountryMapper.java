package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;

import java.util.ArrayList;
import java.util.List;

public class CountryMapper {

    private IconMapper iconMapper;

    public CountryMapper(IconMapper iconMapper) {
        this.iconMapper = iconMapper;
    }

    public CountryDTO countryEntity2DTO(CountryEntity entity, boolean loadIcons){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setImageCountry(entity.getImage());
        countryDTO.setDenominationCountry(entity.getDenomination());
        countryDTO.setPopulation(entity.getPopulation());
        countryDTO.setArea(entity.getArea());
        if (loadIcons){
            List<IconDTO> iconDTOS = this.iconMapper.iconEntityList2DTOList(entity.getIcons(), loadIcons false);
            countryDTO.setIcons(iconDTOS);
        }
        return countryDTO;
    }

    public CountryEntity countryDTO2Entity(CountryDTO dto, boolean loadIcons){
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(dto.getId());
        countryEntity.setImage(dto.getImageCountry());
        countryEntity.setDenomination(dto.getDenominationCountry());
        countryEntity.setPopulation(dto.getPopulation());
        countryEntity.setArea(dto.getArea());
        if (loadIcons){
            List<IconEntity> iconEntities = this.iconMapper.iconDTOList2EntityList(dto.getIcons(), loadIcons false);
            countryEntity.setIcons(iconEntities);
        }
        return countryEntity;
    }

    public List<CountryDTO> countryEntityList2DTOList(List<CountryEntity> entities, boolean loadIcons){
        List<CountryDTO> dtos = new ArrayList<>();
        for (CountryEntity entity : entities){
            dtos.add(this.countryEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }

    public List<CountryDTO> countryDTOList2EntityList(List<CountryDTO> dtos, boolean loadIcons){
        List<CountryDTO> entities = new ArrayList<>();
        for (CountryEntity dto : dtos){
            dtos.add(this.countryEntity2DTO(dto, loadIcons));
        }
        return entities;
    }


}
