package com.alkemy.icons.iconos.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "continent")
public class ContinentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String denomination;

    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL)
    private List<CountryEntity> countries = new ArrayList<>();

}
