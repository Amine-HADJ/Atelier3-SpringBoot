package com.cardgame.User;

import com.cardgame.User.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<AppUser,Integer> {
    AppUser findByEmail(String email);
    AppUser findByUsername(String username);
}