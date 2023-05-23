package com.pragma.powerup.smallsquaremicroservice.domain.api;

import com.pragma.powerup.smallsquaremicroservice.domain.model.Plate;

public interface IPlateServicePort {
    void createPlate(Plate plate);
    Plate getPlate(Long id);
    void updatePlate(Plate plate);

}
