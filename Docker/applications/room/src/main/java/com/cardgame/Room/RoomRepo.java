package com.cardgame.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {
    Room findById(int id);
    Room findByUser1id(int user1id);
    Room findByUser2id(int user2id);
}