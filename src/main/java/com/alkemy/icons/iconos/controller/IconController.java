package com.alkemy.icons.iconos.controller;

import com.alkemy.icons.iconos.dto.IconBasicDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {

    private final IconService iconService;

    public IconController(IconService iconService) {
        this.iconService = iconService;
    }

<<<<<<< Updated upstream
    @GetMapping
    public ResponseEntity<List<IconBasicDTO>> getAll(){
        List<IconBasicDTO> icons = this.iconService.getAllIcons();
=======
    //Devuelve Lista de iconos con todos los detalles
    @GetMapping({"/detail"})
    public ResponseEntity<List<IconDTO>> getAllIcons(){
        List<IconDTO> icons = this.iconService.getAllIcons();
>>>>>>> Stashed changes
        return ResponseEntity.ok().body(icons);
    }

    //Devuelve lista de iconos con detalles acotados
    @GetMapping
    public ResponseEntity<List<IconBasicDTO>> getAllBasicIcons(){
        List<IconBasicDTO> icons = this.iconService.getAllBasicIcons();
        return ResponseEntity.ok().body(icons);
    }

    //Borrado soft de Icono especifico por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> sDelete(@PathVariable Long id){
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Crea un icono
    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO saveIcon = this.iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveIcon);
    }

    //Sobreescribe un icono especifico
    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> edit(@PathVariable Long id, @RequestBody IconDTO iconDTO){
        IconDTO editIcon = this.iconService.edit(id, iconDTO);
        return ResponseEntity.ok(editIcon);
    }
}
