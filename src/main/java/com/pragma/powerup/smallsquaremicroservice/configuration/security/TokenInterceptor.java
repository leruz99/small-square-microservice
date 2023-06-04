package com.pragma.powerup.smallsquaremicroservice.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.UserNotRoleOwnerExceptio;
import com.pragma.powerup.smallsquaremicroservice.configuration.security.exceptio.TokenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final String PREFIX = "Bearer ";
    private static final String OWNER = "ROLE_OWNER";
    private static final String ADMIN = "ROLE_ADMIN";


    private static String token;
    @Setter
    private static Long idOwner;

    public static String getToken() {
        return token;
    }

    public static Long getIdOwner() {
        return idOwner;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        token = request.getHeader("Authorization");
        if (token == null && !token.startsWith(PREFIX)){
            throw new TokenException();
        }
        String jwtToken = token.substring(PREFIX.length());

        List<String> roles;

        DecodedJWT decodedJWT = JWT.decode(jwtToken);

        roles = decodedJWT.getClaim("roles").asList(String.class);
        idOwner = decodedJWT.getClaim("id").asLong();


        String roleUser = roles.get(0);

        if (ADMIN.equals(roleUser) && isAdmin(request.getRequestURI()) ){
            return true;
        }
        if (OWNER.equals(roleUser) && isOwner(request.getRequestURI()) ){
            return true;
        }
        throw new UserNotRoleOwnerExceptio();

    }
    private boolean isOwner(String requestURI){
        return requestURI.startsWith("/plate/");
    }
    private boolean isAdmin(String requestURI){
        return requestURI.startsWith("/restaurant/");
    }
}
