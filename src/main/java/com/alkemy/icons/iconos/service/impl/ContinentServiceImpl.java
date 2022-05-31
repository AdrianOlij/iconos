package com.alkemy.icons.iconos.service.impl;

import com.alkemy.icons.iconos.dto.ContinentDTO;
import com.alkemy.icons.iconos.entities.ContinentEntity;
import com.alkemy.icons.iconos.mapper.ContinentMapper;
import com.alkemy.icons.iconos.repository.ContinentRepository;
import com.alkemy.icons.iconos.service.ContinentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    private final ContinentMapper continentMapper;
    private final ContinentRepository continentRepository;

    public ContinentServiceImpl(ContinentMapper continentMapper, ContinentRepository continentRepository) {
        this.continentMapper = continentMapper;
        this.continentRepository = continentRepository;
    }

    @Transactional
    @Override
    public ContinentDTO save(ContinentDTO dto) {
        ContinentEntity entity = this.continentMapper.continentDTO2Entity(dto); // Lo convierto en Entity
        ContinentEntity entitySaved = this.continentRepository.save(entity); // Lo guardo
        return this.continentMapper.continentEntity2DTO(entitySaved); // Lo devuelvo
    }

    @Transactional
    @Override
    public List<ContinentDTO> getAllContinents() {
        List<ContinentEntity> entities = this.continentRepository.findAll();
        return this.continentMapper.continentEntityList2DTOList(entities);
    }

    @Transactional
    @Override
    public ContinentDTO getAContinent(Long id) {
        return this.continentMapper.continentEntity2DTO(this.continentRepository.getById(id));
    }
}
