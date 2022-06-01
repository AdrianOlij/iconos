package com.alkemy.icons.iconos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryDTO {

    private Long id;
    private String image;
    private String denomination;
    private Long population;
    private Double area;
    private Long continentId;
    private List<IconDTO> icons;
}
