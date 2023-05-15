package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.mapper;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;



@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantRequestMapper {

    Restaurant toRestaurant(RestaurantRequestDto restaurantRequestDto);
    RestaurantResponseDto toRestaurantResponseDto(Restaurant restaurant);
}
