package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    Optional<RestaurantEntity> findByNit(String dni);
    Boolean existsByName(String name);
    //List<UserEntity> findAllById(Long id);
}
