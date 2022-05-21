package com.alkemy.icons.iconos.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class IconDTO {

    private Long id;
    private String iconImage;
    private String iconDenomination;
    private String creationDate;
    private Long height;
    private String history;
    private List<CountryDTO> countries;
}
