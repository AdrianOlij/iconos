package com.alkemy.icons.iconos.controller;


import com.alkemy.icons.iconos.dto.IconDTO;
import com.alkemy.icons.iconos.service.IconService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    }

}
