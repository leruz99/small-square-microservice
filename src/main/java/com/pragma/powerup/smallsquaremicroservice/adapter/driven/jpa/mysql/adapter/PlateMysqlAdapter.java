package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.adapter;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.entity.PlateEntity;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.Category.CategoryNotFoundException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.plate.PlateNotFoundException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.plate.RestaurantNoExistException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper.IPlateEntityMapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.ICategoryRepository;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.IPlateRepository;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Plate;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.IPlatePersitencePort;

public class PlateMysqlAdapter  implements IPlatePersitencePort {

    private final IPlateRepository plateRepository;
    private final IPlateEntityMapper plateEntityMapper;
    private final IRestaurantRepository restaurantRepository;
    private final ICategoryRepository categoryRepository;

    public PlateMysqlAdapter(IPlateRepository plateRepository, IPlateEntityMapper plateEntityMapper, IRestaurantRepository restaurantRepository, ICategoryRepository categoryRepository) {
        this.plateRepository = plateRepository;
        this.plateEntityMapper = plateEntityMapper;
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createPlate(Plate plate) {
        if (!(categoryRepository.existsById(plate.getCategory().getId()))) {
            throw new CategoryNotFoundException();
        }
        if (restaurantRepository.findById(plate.getRestaurant().getId()).isEmpty()){
            throw new RestaurantNoExistException();
        }
        plateRepository.save(plateEntityMapper.toPlateEntity(plate));

    }

    @Override
    public Plate getPlate(Long id) {
        if (!(plateRepository.existsById(id))){
            throw new PlateNotFoundException();
        }
        return plateEntityMapper.toPlate(plateRepository.findById(id).get());
    }

    @Override
    public void updatePlate(Plate plate) {
        plateRepository.save(plateEntityMapper.toPlateEntity(plate));

    }


}
