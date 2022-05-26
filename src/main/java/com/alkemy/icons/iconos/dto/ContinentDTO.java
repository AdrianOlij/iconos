package com.alkemy.icons.iconos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ContinentDTO {
    private Long id;
    private String image;
    private String denomination;
    //private List<CountryDTO> countries;
}