package com.cardgame.User;

import com.cardgame.User.AppUser;
import com.cardgame.User.UserService;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;


@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
public class UserController {

    
    private final UserService uService;

    
    public UserController(UserService uService) {
        this.uService = uService;
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> register(@RequestBody AppUser user) {
        boolean exists = uService.checkIfUserExists(user.getUsername(), user.getEmail());
        if (!exists) {
            Integer userId = uService.registerUser(user);
            String userIdStr = userId.toString();
            return ResponseEntity.ok(userIdStr);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with the provided username or email already exists");
        }
    }

    @GetMapping("/users/{userId}")
    @CrossOrigin(origins = "*")
    public Map<String, Object> getUserDetails(@PathVariable String userId) {
        return uService.getUsersDetails(userId);
    }

    @PostMapping("/wallet")
    public ResponseEntity<String> updateUserWallet(@RequestBody String userId, @RequestBody double walletUpdate) {
        uService.updateUserWallet(userId, walletUpdate);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/getuserdetails")
    @CrossOrigin(origins = "*")
    public Map<String, Object> details(@RequestBody String userId) {
        return uService.getUsersDetails(userId);
    }
}
