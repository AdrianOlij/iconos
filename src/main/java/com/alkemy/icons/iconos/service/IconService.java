package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.IconEntity;

import java.util.List;
import java.util.Set;

public interface IconService {

    IconDTO save(IconDTO iconDTO);

    void delete(Long id);

    List<IconDTO> getAllIcons();

    List<IconBasicDTO> getAllBasicIcons();

    IconDTO edit(Long id, IconDTO iconDTO);

    IconDTO getAnIcon(Long id);

    List<IconDTO> getByFilters(String name, String date, Set<Long> countries, String order);

/*  Grisado por si hay un escalado mas adelante
    void addCountry(Long id, Long idCountry);


    void removeCountry(Long id, Long idCountry);
*/
}
