package com.alkemy.icons.iconos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class IconBasicDTO {

    private Long id;
    private String iconImage;
    private String iconDenomination;
}
