package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.entity.PlateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlateRepository extends JpaRepository<PlateEntity, Long> {
}
