package com.cardgame.Auth;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final RestTemplate restTemplate;
    private final String userServiceUrl = "http://localhost:8082";

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Integer checkLogin(String identifier, String password){
        AppUser userByEmail = restTemplate.getForObject(userServiceUrl + "/users/email/" + identifier, AppUser.class);
        AppUser userByUsername = restTemplate.getForObject(userServiceUrl + "/users/username/" + identifier, AppUser.class);
        AppUser user = userByEmail == null ? userByUsername : userByEmail;
        if(password.equals(user.getPassword())){
            return user.getId();
        }
       
    }
    
}