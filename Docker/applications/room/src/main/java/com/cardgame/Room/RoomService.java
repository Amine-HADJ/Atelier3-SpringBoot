package com.cardgame.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepo roomRepo;


    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Optional<Room> getRoomById(int id) {
        return Optional.ofNullable(roomRepo.findById(id));
    }

    public Room createRoom(Room room) {
        return roomRepo.save(room);
    }

    public Room updateRoom(int id, Room room) {
        Room existingRoom = roomRepo.findById(id);
        if (existingRoom == null) {
            throw new RuntimeException("Room not found");
        }
        existingRoom.setUser1id(room.getUser1id());
        existingRoom.setUser2id(room.getUser2id());
        return roomRepo.save(existingRoom);
    }

    public void deleteRoom(int id) {
        roomRepo.deleteById(id);
    }
}