package com.alkemy.icons.iconos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class IconFiltersDTO {
    private String name;
    private String date;
    private Set<Long> countries;
    private String order;

    public IconFiltersDTO(String name, String date, Set<Long> countries, String order) {
        this.name = name;
        this.date = date;
        this.countries = countries;
        this.order = order;
    }

    public boolean isASC(){return this.order.compareToIgnoreCase("ASC") == 0;}

    public boolean isDESC(){return  this.order.compareToIgnoreCase("DESC") == 0;}
}
