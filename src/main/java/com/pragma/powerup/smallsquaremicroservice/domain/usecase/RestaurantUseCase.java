package com.pragma.powerup.smallsquaremicroservice.domain.usecase;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.MicroserviceUserNoWorkingException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.OwnerNotFoundException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.UserNotExistException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.client.UserRestClient;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.smallsquaremicroservice.configuration.Constants;
import com.pragma.powerup.smallsquaremicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Restaurant;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.IRestaurantPersistencePort;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.http.HttpStatus;


public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final UserRestClient userRestClient;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, UserRestClient userRestClient) {
        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userRestClient = userRestClient;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        UserResponseDto userFromMsUser = getUserFromMsUser(restaurant.getIdOwner());

        if (userFromMsUser.getIdRole().equals(Constants.OWNER_ROLE_ID)){
            restaurantPersistencePort.createRestaurant(restaurant);
        }else {
            throw new OwnerNotFoundException();
        }
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantPersistencePort.getRestaurant(id);
    }

    private UserResponseDto getUserFromMsUser(Long idOwner) {
        try {
            return userRestClient.getUserFromMsUser(idOwner);
        } catch (RetryableException e) {
            throw new MicroserviceUserNoWorkingException();
        } catch (FeignException e) {
            HttpStatus statusCode = HttpStatus.valueOf(e.status());
            if (statusCode == HttpStatus.NOT_FOUND) {
                throw new UserNotExistException();
            }
            throw new MicroserviceUserNoWorkingException();
        }
    }

}
