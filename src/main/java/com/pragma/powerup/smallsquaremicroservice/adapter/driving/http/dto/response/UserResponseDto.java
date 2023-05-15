package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDto {

    private String name;
    private String surName;
    private String dni;
    private String phone;
    private String birthdate;
    private String email;
    private String password;
    private Long idRole;
}
