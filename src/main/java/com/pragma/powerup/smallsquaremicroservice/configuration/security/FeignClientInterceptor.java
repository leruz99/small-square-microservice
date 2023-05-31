package com.pragma.powerup.smallsquaremicroservice.configuration.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignClientInterceptor implements RequestInterceptor {


    private static final String AUTHORIZATION_HEADER = "Autorización" ;

    @Override
    public void apply(RequestTemplate template) {
        String token = TokenInterceptor.getToken();
        //template.header(AUTHORIZATION_HEADER,"Bearer " + token);
    }

}
