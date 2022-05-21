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
@Entity
@Table(name = "icon")
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?") /*digo q en realidad no se borre sino q updatee el atributo
                                                               "deleted" a true en el ID que se paso */

@Where(clause = "deleted=false") // Con esto diferencia los que fueron borrados de los q no
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String denomination;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private String creationDate;

    private Long height;
    private String history;
    private boolean delete = Boolean.FALSE; // se agrega una columna para hacer el soft delete donde 1 es borrado y 0 no.

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<CountryEntity> countries = new ArrayList<>();
}
