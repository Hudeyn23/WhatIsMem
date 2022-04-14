package com.nsu.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FirstController {
    @Autowired
    RoomService roomService;

    @GetMapping("/home")
    public String home() {
        return "Home page with buttons like 'join' or 'create'";
    }

    @GetMapping("/rooms")
    public String rooms() {
        return "Page with list of public rooms";
    }

    @GetMapping("/play")
    public String play(@RequestParam(name = "room") String roomID) {
        return "Page with a game. If not enough players then shows players count";
    }

    @GetMapping("/create")
    public String create(@RequestParam(name = "players") String playersCount) {
        int players;
        try {
            players = Integer.parseInt(playersCount); // throws exception if 'players' is not int
            if (players < 1 || players > 20) {
                throw new Exception("Number of players must be from 1 to 20. Nikita ne rugaisya");
            }
        } catch (Exception e) {
            return "Incorrect players count message";
        }
        var newRoom = roomService.createRoom(players);
        return "redirect:/play/" + Integer.toString(newRoom.getID());
    }
}