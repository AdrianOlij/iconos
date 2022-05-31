package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
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

    // DTO a Entity
    public IconEntity iconDTO2Entity(IconDTO iconDTO, boolean loadCountries) {
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImage(iconDTO.getIconImage());
        iconEntity.setDenomination(iconDTO.getIconDenomination());
        iconEntity.setCreationDate(this.string2LocalDate(iconDTO.getCreationDate()));
        iconEntity.setHeight(iconDTO.getHeight());
        iconEntity.setHistory(iconDTO.getHistory());
        if (loadCountries) {
            List<CountryEntity> countriesEntity = this.countryMapper.countryDTOList2EntityList(iconDTO.getCountries());
            iconEntity.setCountries(countriesEntity);
        }
        return iconEntity;
    }

    // Entity a DTO
    public IconDTO iconEntity2DTO(IconEntity iconEntity, boolean loadCountries) {
        IconDTO iconDTO = new IconDTO();
        iconDTO.setId(iconEntity.getId());
        iconDTO.setIconImage(iconEntity.getImage());
        iconDTO.setIconDenomination(iconEntity.getDenomination());
        iconDTO.setCreationDate(iconEntity.getCreationDate().toString());
        iconDTO.setHeight(iconEntity.getHeight());
        iconDTO.setHistory(iconEntity.getHistory());
        if (loadCountries) {
            List<CountryDTO> countriesDTO = this.countryMapper.countryEntityList2DTOList(iconEntity.getCountries(), false);
            iconDTO.setCountries(countriesDTO);
        }
        return iconDTO;
    }

    // Paso String a LocalDate para fecha de creación
    public LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }

    //DTO List a Entity List
    public List<IconEntity> iconDTOList2EntityList(List<IconDTO> dtos) {
        List<IconEntity> iconEntities = new ArrayList<>();
        for (IconDTO dto : dtos) {
            iconEntities.add(this.iconDTO2Entity(dto, false));
        }
        return iconEntities;
    }

    // Entity List a DTO List
    public List<IconDTO> iconEntityList2DTOList(List<IconEntity> iconEntities, boolean loadCountries) {
        List<IconDTO> iconDTOS = new ArrayList<>();
        for (IconEntity iconEntity : iconEntities) {
            iconDTOS.add(this.iconEntity2DTO(iconEntity, loadCountries));
        }
        return iconDTOS;
    }

    // Entity a Basic DTO
    public IconBasicDTO iconEntity2BasicDTO(IconEntity entity) {
        return new IconBasicDTO(entity.getId(), entity.getImage(), entity.getDenomination());
    }

    // Entity List a Basic DTO List
    public List<IconBasicDTO> iconEntityList2BasicDTOList(Collection<IconEntity> entities) {
        return entities.stream()
                .map(iconEntity -> iconEntity2BasicDTO(iconEntity))
                .collect(Collectors.toList());

        /*
    public List<IconBasicDTO> iconEntityList2BasicDTOList(List<IconEntity> entities){
            List<IconBasicDTO> dtos = new ArrayList<>();
            IconBasicDTO basicDto;
            for (IconEntity entity : entities){
                basicDto.setId(entity.getId());
                basicDto.setIconImage(entity.getImage());
                basicDto.setIconDenomination(entity.getDenomination());
                dtos.add(basicDto);
            }
            return dtos;*/
    }
}
