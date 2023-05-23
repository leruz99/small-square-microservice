package com.pragma.powerup.smallsquaremicroservice.configuration;

import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.adapter.CategoryMysqlAdapter;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.adapter.PlateMysqlAdapter;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.adapter.RestaurantMysqlAdapter;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper.IPlateEntityMapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.mapper.IRestaurantEntityMapper;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.ICategoryRepository;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.IPlateRepository;
import com.pragma.powerup.smallsquaremicroservice.adapter.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.client.UserRestClient;
import com.pragma.powerup.smallsquaremicroservice.domain.api.ICategoryServicePort;
import com.pragma.powerup.smallsquaremicroservice.domain.api.IPlateServicePort;
import com.pragma.powerup.smallsquaremicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.IPlatePersitencePort;
import com.pragma.powerup.smallsquaremicroservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.smallsquaremicroservice.domain.usecase.CategoryUseCase;
import com.pragma.powerup.smallsquaremicroservice.domain.usecase.PlateUseCase;
import com.pragma.powerup.smallsquaremicroservice.domain.usecase.RestaurantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final UserRestClient userRestClient;
    private final IPlateRepository plateRepository;
    private final IPlateEntityMapper plateEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;




    @Bean
    public  IRestaurantServicePort restaurantServicePort(){
        return new RestaurantUseCase(restaurantPersistencePort(), userRestClient);
    }
    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(){
        return new RestaurantMysqlAdapter(restaurantRepository,restaurantEntityMapper, userRestClient);
    }
    @Bean
    public IPlateServicePort plateServicePort(){
        return new PlateUseCase(platePersitencePort());
    }

    @Bean
    public IPlatePersitencePort platePersitencePort(){
        return new PlateMysqlAdapter(plateRepository,plateEntityMapper,restaurantRepository, categoryRepository);
    }
    @Bean
    public ICategoryServicePort categoryServicePort(){
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort(){
        return new CategoryMysqlAdapter(categoryRepository, categoryEntityMapper);
    }







}
