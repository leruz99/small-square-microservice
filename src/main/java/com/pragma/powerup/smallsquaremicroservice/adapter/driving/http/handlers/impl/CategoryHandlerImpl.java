package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.impl;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.ICategoryHandler;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.mapper.category.ICategoryRequestMapper;
import com.pragma.powerup.smallsquaremicroservice.domain.api.ICategoryServicePort;
import org.springframework.stereotype.Service;

@Service
public class CategoryHandlerImpl implements ICategoryHandler {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;

    public CategoryHandlerImpl(ICategoryServicePort categoryServicePort, ICategoryRequestMapper categoryRequestMapper) {
        this.categoryServicePort = categoryServicePort;
        this.categoryRequestMapper = categoryRequestMapper;
    }


    @Override
    public void createCategory(CategoryRequestDto categoryRequestDto) {
        categoryServicePort.createCategory(categoryRequestMapper.toCategory(categoryRequestDto));
    }
}
