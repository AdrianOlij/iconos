package com.alkemy.icons.iconos.service;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;

import java.util.List;

public interface IconService {

    IconDTO save(IconDTO iconDTO);

    void delete(Long id);

<<<<<<< Updated upstream
    List<IconBasicDTO> getAllIcons();
=======
    List<IconDTO> getAllIcons();

    List<IconBasicDTO> getAllBasicIcons();

    IconDTO edit(Long id, IconDTO iconDTO);
>>>>>>> Stashed changes
}
