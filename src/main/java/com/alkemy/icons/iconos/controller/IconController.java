package com.alkemy.icons.iconos.controller;


import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("icons")
public class IconController {

    private final IconService iconService;

    public IconController(IconService iconService) {
        this.iconService = iconService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<void> sDelete(@PathVariable Long id){
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO saveIcon = this.iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveIcon);

}
