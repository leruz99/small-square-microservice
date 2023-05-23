package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.PlateRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.PlateResponseDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UpdatePlateteResponseDto;

public interface IPlateHandler {
    void createPlate(PlateRequestDto plateRequestDto);
    PlateResponseDto getPlate(Long id);
    void updatePlate(UpdatePlateteResponseDto updatePlateteResponseDto);

}
