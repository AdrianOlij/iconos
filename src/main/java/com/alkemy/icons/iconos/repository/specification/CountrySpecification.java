package com.alkemy.icons.iconos.repository.specification;

import com.alkemy.icons.iconos.dto.CountryFiltersDTO;
import com.alkemy.icons.iconos.entities.CountryEntity;
import com.alkemy.icons.iconos.entities.IconEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountrySpecification {

    public Specification<CountryEntity> getByFilters(CountryFiltersDTO countryFiltersDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(countryFiltersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denomination")),
                                "%" + countryFiltersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if(!CollectionUtils.isEmpty(countryFiltersDTO.getContinent())){
                Join<CountryEntity, IconEntity> join = root.join("continent", JoinType.INNER);
                Expression<String> continentId = join.get("id");
                predicates.add(continentId.in(countryFiltersDTO.getContinent()));
            }

            query.distinct(true);

            String orderByField = "denomination";
            query.orderBy(
                    countryFiltersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
