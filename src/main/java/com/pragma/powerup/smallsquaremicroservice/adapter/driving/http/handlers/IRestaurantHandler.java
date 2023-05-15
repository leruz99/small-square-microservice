package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.RestaurantResponseDto;


public interface IRestaurantHandler {
    void createRestaurant(RestaurantRequestDto restaurantRequestDto);
    RestaurantResponseDto getRestaurant(Long id);
    //Optional<UserResponseDto> getUser(UserResponseDto userResponseDto);
}
