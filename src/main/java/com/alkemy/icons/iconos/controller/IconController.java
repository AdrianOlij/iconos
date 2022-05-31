package com.alkemy.icons.iconos.controller;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.repository.IconRepository;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {

    private final IconService iconService;

    public IconController(IconService iconService, IconRepository iconRepository) {
        this.iconService = iconService;
    }


    //Devuelve lista de iconos con detalles acotados
    @GetMapping
    public ResponseEntity<List<IconBasicDTO>> getAllBasicIcons() {
        List<IconBasicDTO> icons = this.iconService.getAllBasicIcons();
        return ResponseEntity.ok().body(icons);
    }

    // Devuelve un icono detallado
    @GetMapping("/{id}")
    public ResponseEntity<IconDTO> getAnIcon(@PathVariable Long id){
        IconDTO getAnIcon = this.iconService.getAnIcon(id);
        return ResponseEntity.ok().body(getAnIcon);
    }

    // Agrega un Icono
    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO saveIcon = this.iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveIcon);
    }

    //Update de un icono
    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO iconDTO) {
        IconDTO editIcon = this.iconService.edit(id, iconDTO);
        return ResponseEntity.ok(editIcon);
    }

    // Borra un icono
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> sDelete(@PathVariable Long id) {
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

/* Lo dejo grisado por si en algun momento se requiera agregar un pais a un icono
    //Agrega un pais a un icono
    @PostMapping("/{id}/country/{idCountry}")
    public ResponseEntity<Void> addCountry(@PathVariable Long id, @PathVariable Long idCountry){
        this.iconService.addCountry(id, idCountry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Borra un pais a un icono
    @DeleteMapping("/{id}/country/{idCountry}")
    public ResponseEntity<Void> removeCountry(@PathVariable Long id, @PathVariable Long idCountry){
        this.iconService.removeCountry(id, idCountry);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/
}
