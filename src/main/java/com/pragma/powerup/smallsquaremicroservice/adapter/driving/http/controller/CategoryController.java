package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.controller;


import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.PlateRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.ICategoryHandler;
import com.pragma.powerup.smallsquaremicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/category")
@SecurityRequirement(name = "jwt")
public class CategoryController {
    private final ICategoryHandler categoryHandler;

    public CategoryController(ICategoryHandler categoryHandler) {
        this.categoryHandler = categoryHandler;
    }

    @Operation(summary = "Add a new Plate",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Plate created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Plate already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/new")
    public ResponseEntity<Map<String, String>> saveRestaurant(@Valid @RequestBody CategoryRequestDto categoryRequestDto){
        categoryHandler.createCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.CATEGORY_CREATED_MESSAGE));

    }
}


