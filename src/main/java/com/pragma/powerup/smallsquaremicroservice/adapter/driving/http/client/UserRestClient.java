package com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.client;
import com.pragma.powerup.smallsquaremicroservice.adapter.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.smallsquaremicroservice.configuration.security.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name = "user-microservice", url = "localhost:8090", configuration = FeignClientConfig.class)
public interface UserRestClient {
    @GetMapping("/user/owner/{id}")
    UserResponseDto getUserFromMsUser(@PathVariable Long id);

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

    /**

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper;

    private static final String URL = "http://localhost:8090/user/owner/";

    public UserResponseDto getUser(Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<ObjectNode>  response = restTemplate.exchange(URL.concat(id.toString()), HttpMethod.GET, httpEntity, ObjectNode.class);

        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            throw new UserNotExistException();
        }
        UserResponseDto userResponseDto;
        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody().toString());
            userResponseDto = objectMapper.treeToValue(jsonNode, UserResponseDto.class);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return userResponseDto;
    }
     */





}
