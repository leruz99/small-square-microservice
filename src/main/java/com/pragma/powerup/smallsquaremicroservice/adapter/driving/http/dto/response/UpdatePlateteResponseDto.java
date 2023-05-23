package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdatePlateteResponseDto {

    private Long id;
    private double price;
    private String description;

}
