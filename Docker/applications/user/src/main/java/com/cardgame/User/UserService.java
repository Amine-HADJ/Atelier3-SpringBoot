package com.cardgame.User;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@SuppressWarnings("unchecked")
public class UserService {

    private final UserRepo userRepo;
    private final RestTemplate restTemplate;
    private final String cardServiceUrl = "http://card/";

    public UserService(UserRepo userRepo, RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.restTemplate = restTemplate;
    }

    public boolean checkIfUserExists(String username, String email){
        AppUser byEmail = userRepo.findByEmail(email);
        AppUser byUsername = userRepo.findByUsername(username);
    
        return byEmail != null || byUsername != null;
    }

    public Integer registerUser(AppUser user) {
        AppUser newUser = new AppUser(user.getUsername(), user.getEmail(), user.getPassword());
        List<Map<String, Object>> cards = restTemplate.getForObject(cardServiceUrl + "/cards", List.class);
        String addCardsUrl = cardServiceUrl + "/setcard";
        cards.forEach(card -> {
            restTemplate.postForObject(addCardsUrl, card, Void.class);
        });
        
        AppUser savedUser = userRepo.save(newUser);

        return savedUser.getId();
    }

    public Map<String, Object> getUsersDetails(String userId) {
        Integer userIdInt = Integer.parseInt(userId);
        Optional<AppUser> userOptional = userRepo.findById(userIdInt);
        if (userOptional.isPresent()) {
            AppUser user = userOptional.get();
            String username = user.getUsername();
            Double userMoney = user.getWallet();
            
            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("username", username);
            userDetails.put("wallet", userMoney);
            
            return userDetails;
        }
        return null;
    }

    public void updateUserWallet(String userId, double wallet) {
        Integer userIdInt = Integer.parseInt(userId);
        Optional<AppUser> userOptional = userRepo.findById(userIdInt);
        if (userOptional.isPresent()) {
            AppUser user = userOptional.get();
            user.setWallet(user.getWallet() + wallet);
            userRepo.save(user);
        }
    }
}