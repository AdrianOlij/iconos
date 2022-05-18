package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.entities.ContinentEntity;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper {

    public ContinentEntity continentDTO2Entity(ContinentDTO dto){
        ContinentEntity continentEntity = new ContinentEntity();
        continentEntity.setImage(dto.getImage());
        continentEntity.setDenomination(dto.getDenomination());
        return continentEntity;
    }

    public ContinentDTO continentEntity2DTO(ContinentEntity entity){
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setId(entity.getId());
        continentDTO.setImage(entity.getImage());
        continentDTO.setDenomination(entity.getImage());
        return continentDTO;
    }
}
