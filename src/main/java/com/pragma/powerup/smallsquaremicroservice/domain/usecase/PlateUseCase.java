package com.pragma.powerup.smallsquaremicroservice.domain.usecase;

import com.pragma.powerup.smallsquaremicroservice.domain.api.IPlateServicePort;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Plate;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.IPlatePersitencePort;

import java.util.Optional;

public class PlateUseCase implements IPlateServicePort {

    private final IPlatePersitencePort platePersitencePort;

    public PlateUseCase(IPlatePersitencePort platePersitencePort) {
        this.platePersitencePort = platePersitencePort;
    }

    @Override
    public void createPlate(Plate plate) {
        platePersitencePort.createPlate(plate);
    }

    @Override
    public Plate getPlate(Long id) {
        return platePersitencePort.getPlate(id);
    }

    @Override
    public void updatePlate(Plate plate) {
        Optional<Plate> plateFound = Optional.ofNullable(platePersitencePort.getPlate(plate.getId()));

        plate.setName(plateFound.get().getName());
        plate.setUrlImage(plateFound.get().getUrlImage());
        plate.setActive(plateFound.get().isActive());
        plate.setCategory(plateFound.get().getCategory());
        plate.setRestaurant(plateFound.get().getRestaurant());

        platePersitencePort.updatePlate(plate);
    }


}
