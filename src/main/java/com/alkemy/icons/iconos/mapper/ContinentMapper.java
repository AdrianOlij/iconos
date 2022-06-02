package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.entities.ContinentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinentMapper {

    private final CountryMapper countryMapper;

    public ContinentMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    public ContinentEntity continentDTO2Entity(ContinentDTO continentDTO){
        // Instancio el objeto al q quiero convertir el DTO
        ContinentEntity continentEntity = new ContinentEntity();
        // cargo el atributo al Entity desde el atributo correlativo del DTO
        continentEntity.setImage(continentDTO.getImage());
        // idem anterior
        continentEntity.setDenomination(continentDTO.getDenomination());

        return continentEntity;
    }

    public ContinentDTO continentEntity2DTO(ContinentEntity continentEntity){
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setId(continentEntity.getId());
        continentDTO.setImage(continentEntity.getImage());
        continentDTO.setDenomination(continentEntity.getDenomination());
        continentDTO.setCountries(this.countryMapper.countryEntityList2DTOList(continentEntity.getCountries(), true));
        return continentDTO;
    }

    public List<ContinentDTO> continentEntityList2DTOList(List<ContinentEntity> entities){
        List<ContinentDTO> dtos = new ArrayList<>(); /* Instancio el List de dtos que quiero devolver */

        for (ContinentEntity entity: entities){
            dtos.add(continentEntity2DTO(entity));
        } /* recorro el list entities del tipo ContinentEntity q recibimos como argumento y lo agregamos al List dtos
             reutilizando el metodo continentEntity2DTO de mas arriba */

        return dtos; // Devuelvo el List de continentes en formato dto.
    }


}
