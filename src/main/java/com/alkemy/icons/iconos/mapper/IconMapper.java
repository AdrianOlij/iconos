package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IconMapper {

    private final CountryMapper countryMapper;

    public IconMapper(@Lazy CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    public IconEntity iconDTO2Entity(IconDTO dto){
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImage(dto.getIconImage());
        iconEntity.setDenomination(dto.getIconDenomination());
        iconEntity.setCreationDate(this.string2LocalDate(dto.getCreationDate()));
        iconEntity.setHeight(dto.getHeight());
        iconEntity.setHistory(dto.getHistory());

        return iconEntity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadCountries){
        IconDTO iconDTO = new IconDTO();
        iconDTO.setId(entity.getId());
        iconDTO.setIconImage(entity.getImage());
        iconDTO.setIconDenomination(entity.getDenomination());
        iconDTO.setCreationDate(entity.getCreationDate().toString());
        iconDTO.setHeight(entity.getHeight());
        iconDTO.setHistory(entity.getHistory());
        if (loadCountries){
            List<CountryDTO> countriesDTO = this.countryMapper.countryEntityList2DTOList(entity.getCountries(), false);
            iconDTO.setCountries(countriesDTO);
        }
        return iconDTO;
    }

    public LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }

    public List<IconEntity> iconDTOList2EntityList(List<IconDTO> dtos, boolean loadIcons){
        List<IconEntity> iconEntities = new ArrayList<>();
        for (IconDTO dto : dtos){
            iconEntities.add(this.iconDTO2Entity(dto));
        }
        return iconEntities;
    }

    public List<IconDTO> iconEntityList2DTOList(List<IconEntity> entities, boolean loadCountries) {
        List<IconDTO> dtos = new ArrayList<>();
        for (IconEntity entity : entities) {
            dtos.add(this.iconEntity2DTO(entity, loadCountries));
        }
        return dtos;
        //TODO: falta terminar el IconEntityList2DTOList
    }

    public IconBasicDTO iconEntity2BasicDTO(IconEntity entity){
        return new IconBasicDTO(entity.getId(), entity.getImage(), entity.getDenomination());
    }
    public List<IconBasicDTO> iconEntitySet2BasicDTOList(Collection<IconEntity> entities){
        return entities.stream()
                .map(iconEntity -> iconEntity2BasicDTO(iconEntity))
                .collect(Collectors.toList());

    /*    List<IconBasicDTO> dtos = new ArrayList<>();
        IconBasicDTO basicDto;
        for (IconEntity entity : entities){
            basicDto = new IconBasicDTO();
            basicDto.setId(entity.getId());
            basicDto.setIconImage(entity.getImage());
            basicDto.setIconDenomination(entity.getDenomination());
            dtos.add(basicDto);
        }
        return dtos;*/
    }
}
