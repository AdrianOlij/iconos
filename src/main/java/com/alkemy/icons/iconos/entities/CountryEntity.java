package com.alkemy.icons.iconos.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SQLDelete(sql = "UPDATE country SET deleted = trie WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String denomination;

    @Column(name = "amount_population")
    private Long population;
    private Double area; //metros cuadrados
    private boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)              //
    @JoinColumn(name = "continent_id", insertable = false, updatable = false)  // Busqueda de información
    private ContinentEntity continent;                                          //

    @Column(name = "continent_id", nullable = false)                            // Edición
    private Long continentId;                                                  //

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_country",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private List<IconEntity> icons = new ArrayList<>();



    public void addIcon(IconEntity iconEntity) {
        this.icons.add(iconEntity);
    }

    public void removeIcon(IconEntity iconEntity){
        this.icons.remove(iconEntity);
    }
}
