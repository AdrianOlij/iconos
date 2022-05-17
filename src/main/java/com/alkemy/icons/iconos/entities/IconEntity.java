package com.alkemy.icons.iconos.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String denomination;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate creationDate;

    private Long height;
    private String history;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<CountryEntity> countrys = new ArrayList<>();
}
