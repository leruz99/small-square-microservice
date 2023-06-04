package com.pragma.powerup.smallsquaremicroservice.configuration;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.Category.CategoryAlreadyExistException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.Category.CategoryNotFoundException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.plate.PlateNotFoundException;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.exceptions.plate.RestaurantNoExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.WRONG_CREDENTIALS_MESSAGE));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.NO_DATA_FOUND_MESSAGE));
    }


    @ExceptionHandler(RoleNotAllowedForCreationException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotAllowedForCreationException(
            RoleNotAllowedForCreationException roleNotAllowedForCreationException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.ROLE_NOT_ALLOWED_MESSAGE));
    }


    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotFoundException(
            RoleNotFoundException roleNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.ROLE_NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(
            OwnerNotFoundException ownerNotFoundException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, "The found user is not an owner"));
    }
    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<Map<String, String>> handleOwnerNotFoundException(
            UserNotExistException userNotExistException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.OWNER_NOT_FOUND_MESSAGE));
    }
    @ExceptionHandler(NitAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleNitAlreadyExistExceptionn(
            NitAlreadyExistException nitAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.NIT_ALREADY_EXIST_MESSAGE));
    }
    @ExceptionHandler(NameRestauranAlreadyExistExeception.class)
    public ResponseEntity<Map<String, String>> handleNameRestauranAlreadyExistExeception(
            NameRestauranAlreadyExistExeception nitAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.NAME_ALREADY_EXIST_MESSAGE));
    }
    @ExceptionHandler(RestaurantNoExistException.class)
    public ResponseEntity<Map<String, String>> handleRestaurantNoExistExceptionExeception(
            RestaurantNoExistException restaurantNoExistException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.RESTAURANT_NOT_FOUND));
    }
    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleCategoryAlreadyExistException(
            CategoryAlreadyExistException categoryAlreadyExist) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.CATEGORY_ALREADY_EXIST_MESSAGE));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(
            CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.CATEGORY_NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(PlateNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePlateNotFoundException(
            PlateNotFoundException plateNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.PLATE_NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(MicroserviceUserNoWorkingException.class)
    public ResponseEntity<Map<String, String>> handleMicroserviceUserNoWorkingException(
            MicroserviceUserNoWorkingException microserviceUserNoWorkingException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.MICROSERVICE_NOT_WORKING));
    }
    @ExceptionHandler(UserNotRoleOwnerExceptio.class)
    public ResponseEntity<Map<String, String>> handleUserNotRoleOwnerExceptio(
            UserNotRoleOwnerExceptio userNotRoleOwnerExceptio) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(Constants.RESPONSE_ERROR_MESSAGE_KEY, Constants.USER_NOT_ROLE_OWNER));
    }


}
