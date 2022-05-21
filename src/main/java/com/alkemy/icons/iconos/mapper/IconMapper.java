package com.alkemy.icons.iconos.mapper;

import com.alkemy.icons.iconos.dto.CountryDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.IconEntity;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class IconMapper {

    private CountryMapper countryMapper;

    public IconMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    private IconEntity iconDTO2Entity(IconDTO dto){
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImage(dto.getIconImage());
        iconEntity.setDenomination(dto.getIconDenomination());
        iconEntity.setCreationDate(
                this.string2LocalDate(dto.setCreationDate())
        );
        iconEntity.setHeight(dto.getHeight());
        iconEntity.setHistory(dto.getHistory());
        return iconEntity;
    }

    private IconDTO iconEntity2DTO(IconEntity entity, boolean loadCountries){
        IconDTO iconDTO = new IconDTO();
        iconDTO.setId(entity.getId());
        iconDTO.setIconImage(entity.getImage());
        iconDTO.setIconDenomination(entity.getDenomination());
        iconDTO.setCreationDate(entity.getCreationDate().toString());
        iconDTO.setHeight(entity.getHeight());
        iconDTO.setHistory(entity.getHistory());
        if (loadCountries){
            List<CountryDTO> countriesDTO = this.countryMapper.countryEntityList2DTOList(entity.getCountries(),
                    loadCountries false);
            iconDTO.setCountries(countriesDTO);
        }
        return iconDTO;
    }

    private LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }

    private List<IconEntity> iconDTOList2EntityList(List<IconDTO> dtos, boolean loadCountries){
        List<IconEntity> iconEntities = new ArrayList<>();
        //TODO:  falta terminar esto
    }

    //TODO: falta terminar el IconEntityList2DTOList
}
