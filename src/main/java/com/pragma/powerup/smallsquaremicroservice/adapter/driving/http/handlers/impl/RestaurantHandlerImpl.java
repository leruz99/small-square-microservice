package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.impl;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.client.UserRestClient;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.IRestaurantHandler;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.smallsquaremicroservice.domain.api.IRestaurantServicePort;
import org.springframework.stereotype.Service;


@Service
public class RestaurantHandlerImpl implements IRestaurantHandler {
    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;


    public RestaurantHandlerImpl(IRestaurantServicePort restaurantServicePort, IRestaurantRequestMapper restaurantRequestMapper) {
        this.restaurantServicePort = restaurantServicePort;
        this.restaurantRequestMapper = restaurantRequestMapper;

    }

    @Override
    public void createRestaurant(RestaurantRequestDto restaurantRequestDto) {
        restaurantServicePort.createRestaurant(restaurantRequestMapper.toRestaurant(restaurantRequestDto));
    }

    @Override
    public RestaurantResponseDto getRestaurant(Long id) {
        return restaurantRequestMapper.toRestaurantResponseDto(restaurantServicePort.getRestaurant(id));
    }


}
