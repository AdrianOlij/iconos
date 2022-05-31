package com.alkemy.icons.iconos.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//digo q en realidad no se borre sino q updatee el atributo "deleted" a true en el ID que se paso */
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
// Con esto diferencia los que fueron borrados de los q no
@Where(clause = "deleted=false")
@Entity
@Table(name ="icon")
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String denomination;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate creationDate;

    private Long height;
    private String history;
    private boolean deleted = Boolean.FALSE; // se agrega una columna para hacer el soft delete donde 1 es borrado y 0 no.

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<CountryEntity> countries = new ArrayList<>();

/*  Grisado por si hay un escalado mas adelante
    public void addCountry(CountryEntity country){
        this.countries.add(country);
    }

    public void removeCountry(CountryEntity country){
        this.countries.remove(country);
    }
*/
}
