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

    @GetMapping
    public ResponseEntity<List<IconDTO>> getAll(){
        List<IconDTO> icons = this.iconService.getAllIcons();
        return ResponseEntity.ok().body(icons);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> sDelete(@PathVariable Long id){
        this.iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO saveIcon = this.iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveIcon);
    }
}
