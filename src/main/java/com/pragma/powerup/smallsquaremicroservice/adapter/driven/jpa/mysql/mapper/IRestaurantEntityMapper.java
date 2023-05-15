package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;



@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {
    RestaurantEntity toRestaurantEntity(Restaurant restaurant);
}
