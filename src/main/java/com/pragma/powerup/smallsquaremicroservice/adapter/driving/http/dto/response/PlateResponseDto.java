package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlateResponseDto {
    private String name;
    private Long categoryId;
    private String description;
    private double price;
    private Long restaurantId;
    private String urlImage;
    private boolean active;
}
