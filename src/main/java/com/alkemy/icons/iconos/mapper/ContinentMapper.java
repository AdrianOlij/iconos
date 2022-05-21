package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.entities.ContinentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinentMapper {

    public ContinentEntity continentDTO2Entity(ContinentDTO dto){
        ContinentEntity continentEntity = new ContinentEntity(); // Instancio el objeto al q quiero convertir el DTO

        continentEntity.setImage(dto.getImage()); /* cargo el atributo al Entity desde el atributo correlativo
                                                     del DTO */

        continentEntity.setDenomination(dto.getDenomination()); // idem anterior

        return continentEntity;
    }

    public ContinentDTO continentEntity2DTO(ContinentEntity entity){
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setId(entity.getId());
        continentDTO.setImage(entity.getImage());
        continentDTO.setDenomination(entity.getImage());
        return continentDTO;
        /* Inverso a continentDTO2Entity */
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
