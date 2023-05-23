package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.mapper.plate;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.PlateRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.PlateResponseDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UpdatePlateteResponseDto;
import com.pragma.powerup.smallsquaremicroservice.domain.model.Plate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlateRequestMapper {

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "restaurant.id", source = "restaurantId")
    Plate toPlate(PlateRequestDto plateRequestDto);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "restaurantId", source = "restaurant.id")
    PlateResponseDto toPlateResponseDto(Plate plate);

    Plate toPlate(UpdatePlateteResponseDto updatePlateteResponseDto);
}
