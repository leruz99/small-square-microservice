package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.adapter;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.client.UserRestClient;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.smallsquaremicroservice.configuration.Constants;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Restaurant;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.IRestaurantPersistencePort;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.http.HttpStatus;



public class RestaurantMysqlAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final UserRestClient userRestClient;

    public RestaurantMysqlAdapter(IRestaurantRepository restaurantRepository, IRestaurantEntityMapper restaurantEntityMapper, UserRestClient userRestClient) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantEntityMapper = restaurantEntityMapper;
        this.userRestClient = userRestClient;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        if (restaurantRepository.existsByName(restaurant.getName())){
            throw new NameRestauranAlreadyExistExeception();
        }
        if (restaurantRepository.findByNit(restaurant.getNit()).isPresent()){
            throw new NitAlreadyExistException();
        }
        restaurantRepository.save(restaurantEntityMapper.toRestaurantEntity(restaurant));
    }
    @Override
    public Restaurant getRestaurant(Long id) {
        return null;
    }
}
