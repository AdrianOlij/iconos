package com.alkemy.icons.iconos.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
@Getter
@Setter

public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private String image;
    private String denomination;

    @Column(name = "amount_population")
    private Long population;

    private Long area; //metros cuadrados

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)              //
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)  // Busqueda de información
    private ContinentEntity continent;                                          //

    @Column(name = "continent_id", nullable = false)                            // Edición
    private Long continenteId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_country",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();
}
