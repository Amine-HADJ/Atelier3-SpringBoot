package com.cardgame.User;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@SuppressWarnings("unchecked")
public class UserService{

    private final RestTemplate restTemplate;
    private final String cardServiceUrl = "http://card/";
    private final String userServiceUrl = "http://user/";

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean checkIfUserExists(String username, String email){
        boolean byEmail = restTemplate.getForObject(userServiceUrl + "/users/email/" + email, Boolean.class);
        boolean byUsername = restTemplate.getForObject(userServiceUrl + "/users/username/" + username, Boolean.class);

        return byEmail || byUsername;
    }

    public Integer registerUser(AppUser user) {
        AppUser newUser = restTemplate.postForObject(userServiceUrl + "/users", user, AppUser.class);
        List<Map<String, Object>> cards = restTemplate.getForObject(cardServiceUrl + "/cards", List.class);
        cards.forEach(card -> {
            restTemplate.postForObject(userServiceUrl + "/users/" + newUser.getId() + "/cards", card, Map.class);
        });
        AppUser savedUser = restTemplate.postForObject(userServiceUrl + "/users", newUser, AppUser.class);

        return savedUser.getId();
    }

    public Map<String, Object> getUsersDetails(String userId) {
        return restTemplate.getForObject(userServiceUrl + "/users/" + userId, Map.class);
    }
    
   
}