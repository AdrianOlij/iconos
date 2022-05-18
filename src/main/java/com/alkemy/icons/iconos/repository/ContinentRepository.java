package com.alkemy.icons.iconos.repository;


import com.alkemy.icons.iconos.entities.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity, Long> {

}
