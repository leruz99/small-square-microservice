package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.mapper.category;


import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.CategoryResponseDto;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryRequestMapper {
    Category toCategory(CategoryRequestDto categoryRequestDto);
}
