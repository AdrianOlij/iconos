package com.alkemy.icons.iconos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDTO {

    private Long id;
    private String image;
    private String denomination;
    private Long population;
    private Double area;
    private Long continentId;
    private List<IconDTO> icons;
}
