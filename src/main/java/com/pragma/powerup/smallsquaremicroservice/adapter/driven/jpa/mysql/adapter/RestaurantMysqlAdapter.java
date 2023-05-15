package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.adapter;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.NameRestauranAlreadyExistExeception;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.NitAlreadyExistException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.OwnerNotFoundException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.client.UserRestClient;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.smallsquaremicroservice.configuration.Constants;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Restaurant;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.IRestaurantPersistencePort;
import feign.FeignException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;


@Transactional
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
        UserResponseDto userFromMcsvUser = null;
        try {
            userFromMcsvUser= userRestClient.getUserFromMcsvUser(restaurant.getIdOwner());
        }catch (FeignException e){
            ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(Collections.singletonMap("mensaje", "No Owner found with the id provided " +
                            " or communication error " +  e.getMessage()));

        }
        if (userFromMcsvUser.getIdRole() == Constants.OWNER_ROLE_ID){
            restaurantRepository.save(restaurantEntityMapper.toRestaurantEntity(restaurant));
        }else {
            throw new OwnerNotFoundException();
        }

    }
    @Override
    public Restaurant getRestaurant(Long id) {
        return null;
    }
}
