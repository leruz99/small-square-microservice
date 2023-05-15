package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantResponseDto {

    private String name;
    private String address;
    private String nit;
    private String phone;
    private String urlLogo;
    private String idOwner;
}
