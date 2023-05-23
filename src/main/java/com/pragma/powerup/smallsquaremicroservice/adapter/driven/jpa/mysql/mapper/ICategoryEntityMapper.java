package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper;


import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.entity.CategoryEntity;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {

    CategoryEntity toCategoryEntity(Category category);
}
