package com.pragma.powerup.smallsquaremicroservice.domain.spi;

import com.pragma.powerup.smallsquaremicroservice.domain.model.Plate;

public interface IPlatePersitencePort {
    void createPlate(Plate plate);
    Plate getPlate(Long id);
    void updatePlate(Plate plate);




}
