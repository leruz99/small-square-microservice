package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
