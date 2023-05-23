package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.entity.PlateEntity;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Plate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlateEntityMapper {

    @Mapping(target = "categoryId.id", source = "category.id")
    @Mapping(target = "restaurantId.id", source = "restaurant.id")
    PlateEntity toPlateEntity(Plate plate);

    @Mapping(target = "category.id", source = "categoryId.id")
    @Mapping(target = "restaurant.id", source = "restaurantId.id")
    Plate toPlate(PlateEntity plateEntity);


}
