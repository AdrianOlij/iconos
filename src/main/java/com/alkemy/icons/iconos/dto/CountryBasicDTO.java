package com.alkemy.icons.iconos.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
public class CountryBasicDTO {

    private Long id;
    private String image;
    private String denomination;
    private Long population;
}

