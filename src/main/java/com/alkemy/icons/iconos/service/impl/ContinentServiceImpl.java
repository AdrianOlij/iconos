package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.entities.ContinentEntity;
import com.alkemy.icons.iconos.mapper.ContinentMapper;
import com.alkemy.icons.iconos.repository.ContinentRepository;
import com.alkemy.icons.iconos.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    private final ContinentMapper continentMapper;
    private final ContinentRepository continentRepository;

    public ContinentServiceImpl(ContinentMapper continentMapper, ContinentRepository continentRepository) {
        this.continentMapper = continentMapper;
        this.continentRepository = continentRepository;
    }

    public ContinentDTO save(ContinentDTO dto){

        ContinentEntity entity = this.continentMapper.continentDTO2Entity(dto); // Lo convierto en Entity
        ContinentEntity entitySaved = this.continentRepository.save(entity); // Lo guardo
        ContinentDTO result = this.continentMapper.continentEntity2DTO(entitySaved); // Lo convierto a DTO
        return result; // Lo devuelvo
    }

    public List<ContinentDTO> getAllContinents() {
        List<ContinentEntity> entities = this.continentRepository.findAll();
        List<ContinentDTO> results = this.continentMapper.continentEntityList2DTOList(entities);
        return results;
    }
}
