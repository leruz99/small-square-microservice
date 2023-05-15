package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantRequestDto {

    @Pattern(regexp = "^[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*$", message = "The field must contain at least one letter and can include numbers.")
    private String name;

    @NotEmpty(message = "Address can´t be Empty")
    private String address;

    @Digits(integer=20, fraction=0, message="The field must have only integers")
    private String nit;

    @NotEmpty(message = "phone can´t be empty")
    @Pattern(regexp = "^\\+?[0-9]{1,12}$", message = "Invalid phone")
    private String phone;

    private String urlLogo;
    private Long idOwner;
}
