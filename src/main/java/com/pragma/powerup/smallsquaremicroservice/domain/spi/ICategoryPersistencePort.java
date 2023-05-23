package com.pragma.powerup.smallsquaremicroservice.domain.spi;

import com.pragma.powerup.smallsquaremicroservice.domain.model.Category;

public interface ICategoryPersistencePort {
    void createCategory(Category category);
}
