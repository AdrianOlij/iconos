package com.alkemy.icons.iconos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CountryFiltersDTO {

    private String name;
    private Set<Long> continent;
    private String order;

    public CountryFiltersDTO(String name, Set<Long> continent, String order) {
        this.name = name;
        this.continent = continent;
        this.order = order;
    }

    public boolean isASC(){return this.order.compareToIgnoreCase("ASC") == 0;}

    public boolean isDESC(){return  this.order.compareToIgnoreCase("DESC") == 0;}
}
