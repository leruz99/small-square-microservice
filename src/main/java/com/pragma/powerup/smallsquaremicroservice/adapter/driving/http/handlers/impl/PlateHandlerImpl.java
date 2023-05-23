package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.impl;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.PlateRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.PlateResponseDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UpdatePlateteResponseDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.IPlateHandler;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.mapper.plate.IPlateRequestMapper;
import com.pragma.powerup.smallsquaremicroservice.domain.api.IPlateServicePort;
import org.springframework.stereotype.Service;

@Service
public class PlateHandlerImpl implements IPlateHandler {

    private final IPlateServicePort plateServicePort;
    private final IPlateRequestMapper plateRequestMapper;

    public PlateHandlerImpl(IPlateServicePort plateServicePort, IPlateRequestMapper plateRequestMapper) {
        this.plateServicePort = plateServicePort;
        this.plateRequestMapper = plateRequestMapper;
    }

    @Override
    public void createPlate(PlateRequestDto plateRequestDto) {
        plateServicePort.createPlate(plateRequestMapper.toPlate(plateRequestDto));
    }

    @Override
    public PlateResponseDto getPlate(Long id) {
        return plateRequestMapper.toPlateResponseDto(plateServicePort.getPlate(id));
    }

    @Override
    public void updatePlate(UpdatePlateteResponseDto updatePlateteResponseDto) {
        plateServicePort.updatePlate(plateRequestMapper.toPlate(updatePlateteResponseDto));

    }


}
