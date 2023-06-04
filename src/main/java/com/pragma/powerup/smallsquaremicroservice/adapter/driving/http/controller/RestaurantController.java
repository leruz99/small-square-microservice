package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.controller;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.handlers.IRestaurantHandler;
import com.pragma.powerup.smallsquaremicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/restaurant")
@SecurityRequirement(name = "jwt")
public class RestaurantController {

    public final IRestaurantHandler restaurantHandler;

    public RestaurantController(IRestaurantHandler restaurantHandler) {
        this.restaurantHandler = restaurantHandler;
    }

    @Operation(summary = "Add a new Restaurant",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Restaurant created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Restaurant already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/new")
    public ResponseEntity<Map<String, String>> saveRestaurant(@Valid  @RequestBody RestaurantRequestDto restaurantRequestDto){
        restaurantHandler.createRestaurant(restaurantRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.RESTAURANT_CREATED_MESSAGE));

    }
}
