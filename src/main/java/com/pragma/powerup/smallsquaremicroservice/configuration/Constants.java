package com.pragma.powerup.smallsquaremicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Long CLIENT_ROLE_ID = 1L;
    public static final Long OWNER_ROLE_ID = 2L;
    public static final Long PROVIDER_ROLE_ID = 3L;
    public static final int MAX_PAGE_SIZE = 2;
    public static final String USER_NOT_ROLE_OWNER = "User is not a Owner";
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String PLATE_CREATED_MESSAGE = "Plate created successfully";
    public static final String CATEGORY_CREATED_MESSAGE = "Category created successfully";
    public static final String PLATE_UPDATED_MESSAGE = "Plate updated successfully";
    public static final String RESTAURANT_CREATED_MESSAGE = "Restaurant created successfully";
    public static final String RESTAURANT_NOT_FOUND = "Restaurant not found with id provided";
    public static final String PLATE_NOT_FOUND_MESSAGE = "Plate not found with id provided";

    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String NIT_ALREADY_EXIST_MESSAGE = "Already exist restaurant with this Nit";
    public static final String NAME_ALREADY_EXIST_MESSAGE = "Already exist a restaurant with this name";
    public static final String CATEGORY_ALREADY_EXIST_MESSAGE = "Already exist a category with this name";
    public static final String CATEGORY_NOT_FOUND_MESSAGE = "Category not found with the id provided";
    public static final String ROLE_NOT_FOUND_MESSAGE = "No role found with the id provided";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String USER_ALREADY_EXISTS_MESSAGE = "A user already exists with the role provided";
    public static final String OWNER_NOT_FOUND_MESSAGE = "Owner not found";

    public static final String MICROSERVICE_NOT_WORKING = "Microservice not working or communication error";

    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}
