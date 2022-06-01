package com.alkemy.icons.iconos.repository.specification;

import com.alkemy.icons.iconos.dto.IconFiltersDTO;
import com.alkemy.icons.iconos.entities.IconEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class IconSpecification {

    public Specification<IconEntity> getByFilters(IconFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denomination")),
                                "%" +filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }


        }
    }
}
