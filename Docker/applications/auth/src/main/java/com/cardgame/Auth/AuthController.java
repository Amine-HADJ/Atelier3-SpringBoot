package com.cardgame.Auth;

import com.cardgame.Auth.LoginRequest;
import com.cardgame.Auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> login(@RequestBody LoginRequest req) {
        Integer check = authService.checkLogin(req.getUsernameOrEmail(), req.getPassword());
        if (check > -1) {
            return ResponseEntity.ok(check.toString());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
