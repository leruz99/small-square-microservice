package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.client;

import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.smallsquaremicroservice.configuration.security.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "user-microservice", url = "localhost:8090", configuration = FeignClientConfig.class)
public interface UserRestClient {

    @GetMapping("/user/owner/{id}")
    UserResponseDto getUserFromMcsvUser(@PathVariable Long id);

    /**
    {
        "name": "luis",
        "surName": "ruz",
        "dni": "147852",
        "phone": "+543136568154",
        "birthdate": "2018-10-05",
        "email": "ruzmenco@gmail.com",
        "password": "5489655",
        "idRole": 2
    }
     */



}
