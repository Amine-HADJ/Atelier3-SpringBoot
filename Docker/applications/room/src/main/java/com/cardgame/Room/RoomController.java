package com.cardgame.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomRepo roomRepo;

    public RoomController(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id) {
        return roomRepo.findById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepo.save(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable int id, @RequestBody Room room) {
        Room existingRoom = roomRepo.findById(id);
        existingRoom.setUser1id(room.getUser1id());
        existingRoom.setUser2id(room.getUser2id());
        return roomRepo.save(existingRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable int id) {
        roomRepo.deleteById(id);
    }
}