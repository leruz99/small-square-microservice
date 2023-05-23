package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.controller;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.PlateRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.PlateResponseDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UpdatePlateteResponseDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.IPlateHandler;
import com.pragma.powerup.smallsquaremicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/plate")
public class PlateController {
    private final IPlateHandler plateHandler;

    public PlateController(IPlateHandler plateHandler) {
        this.plateHandler = plateHandler;
    }

    @Operation(summary = "Add a new Plate",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Plate created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Plate already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/new")
    public ResponseEntity<Map<String, String>> savePlate(@Valid @RequestBody PlateRequestDto plateRequestDto){
        plateHandler.createPlate(plateRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PLATE_CREATED_MESSAGE));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PlateResponseDto> getPlate(@PathVariable Long id){
        return ResponseEntity.ok(plateHandler.getPlate(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> updatePlate(@Valid @RequestBody UpdatePlateteResponseDto updatePlateteResponseDto){
        plateHandler.updatePlate(updatePlateteResponseDto);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PLATE_UPDATED_MESSAGE));

    }


}
