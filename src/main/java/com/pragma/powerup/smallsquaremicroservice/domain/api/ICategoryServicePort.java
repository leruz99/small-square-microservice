package com.pragma.powerup.smallsquaremicroservice.domain.api;

import com.pragma.powerup.smallsquaremicroservice.domain.model.Category;

public interface ICategoryServicePort {
    void createCategory(Category category);
}
