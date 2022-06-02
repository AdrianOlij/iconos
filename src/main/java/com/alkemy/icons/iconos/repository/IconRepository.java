package com.alkemy.icons.iconos.repository;

import com.alkemy.icons.iconos.entities.IconEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long>, JpaSpecificationExecutor<IconEntity> {

    List<IconEntity> findAll(Specification<IconEntity> spec);
}
