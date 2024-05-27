package com.cardgame.Auth;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@SuppressWarnings("unchecked")
public class AuthService {

    private final RestTemplate restTemplate;
    private final String userServiceUrl = "http://user/";

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Integer checkLogin(String identifier, String password){
        Map<String, Object> userByEmail = restTemplate.getForObject(userServiceUrl + "/users/email/" + identifier, Map.class);
        Map<String, Object> userByUsername = restTemplate.getForObject(userServiceUrl + "/users/username/" + identifier, Map.class);
        Map<String, Object> user = userByEmail == null ? userByUsername : userByEmail;
        if(password.equals(user.get("password"))){
            return (Integer) user.get("id");
        }
        return null;
    }
    
}