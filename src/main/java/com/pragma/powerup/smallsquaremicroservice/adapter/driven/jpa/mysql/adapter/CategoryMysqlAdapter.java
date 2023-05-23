package com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.adapter;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.Category.CategoryAlreadyExistException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.ICategoryRepository;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Category;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.ICategoryPersistencePort;

public class CategoryMysqlAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    public CategoryMysqlAdapter(ICategoryRepository categoryRepository, ICategoryEntityMapper categoryEntityMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    @Override
    public void createCategory(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()){
            throw new CategoryAlreadyExistException();
        }
        categoryRepository.save(categoryEntityMapper.toCategoryEntity(category));

    }
}
