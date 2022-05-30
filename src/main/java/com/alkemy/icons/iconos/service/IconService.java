package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.entities.IconEntity;

import java.util.List;

public interface IconService {

    IconDTO save(IconDTO iconDTO);

    void delete(Long id);

    List<IconDTO> getAllIcons();

    List<IconBasicDTO> getAllBasicIcons();

    IconDTO edit(Long id, IconDTO iconDTO);

    IconDTO getAnIcon(Long id);

    void addCountry(Long id, Long idCountry);

    void removeCountry(Long id, Long idCountry);

    IconEntity getEntityById(Long idIcon);
}
