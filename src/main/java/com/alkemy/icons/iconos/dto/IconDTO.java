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
public class IconDTO {

    private Long id;
    private String iconImage;
    private String iconDenomination;
    private String creationDate;
    private Long height;
    private String history;
    private List<CountryDTO> countries;
}
