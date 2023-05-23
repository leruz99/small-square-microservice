package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryRequestDto {
    private String name;
    private String description;
}
