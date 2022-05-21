package com.alkemy.icons.iconos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDTO {

    private Long id;
    private String imageCountry;
    private String denominationCountry;
    private Long population;
    private Double area;
    private List<IconDTO> icons;
}
