package com.alkemy.icons.iconos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContinentDTO {

    private Long id;
    private String image;
    private String denomination;
    private List<CountryDTO> countries;
}