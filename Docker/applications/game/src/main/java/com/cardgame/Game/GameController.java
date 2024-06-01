package com.cardgame.Game;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/game")


public class GameController {

    @GetMapping("/test")
    public String test() {  
        return "ok";
    }
    

}
