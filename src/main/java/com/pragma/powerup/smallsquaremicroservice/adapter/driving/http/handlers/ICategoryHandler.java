package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.CategoryRequestDto;

public interface ICategoryHandler {
    void createCategory(CategoryRequestDto categoryRequestDto);
}
