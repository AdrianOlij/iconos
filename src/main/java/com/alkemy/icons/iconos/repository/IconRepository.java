package com.alkemy.icons.iconos.repository;

import com.alkemy.icons.iconos.entities.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long> {
}
