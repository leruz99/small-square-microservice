package com.pragma.powerup.smallsquaremicroservice.domain.spi;

import com.pragma.powerup.smallsquaremicroservice.domain.model.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


public interface IRestaurantPersistencePort {
    void createRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(Long id);
}
