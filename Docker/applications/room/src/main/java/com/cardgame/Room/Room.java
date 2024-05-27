package com.cardgame.Room;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer user1id;
    private Integer user2id;

    public Room() {
    }

    public Room(Integer user1id, Integer user2id) {
        this.user1id = user1id;
        this.user2id = user2id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser1id() {
        return user1id;
    }

    public void setUser1id(Integer user1id) {
        this.user1id = user1id;
    }

    public Integer getUser2id() {
        return user2id;
    }

    public void setUser2id(Integer user2id) {
        this.user2id = user2id;
    }
}