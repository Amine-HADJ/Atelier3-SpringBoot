package com.cardgame.Card;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.http.ResponseEntity;


@RestController
public class CardController {
    private final CardService cService;

    public CardController(CardService cService) {
        this.cService = cService;
    }

    @GetMapping("/hello")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }





    @PostMapping("/generateCards")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> generateCards() {
        cService.generateAllCards();
        return ResponseEntity.ok("Cards added");
    }

    @GetMapping("/cards/{cardId}")
    @CrossOrigin(origins = "*")
    public Object getCardDetails(@PathVariable String cardId) {
        Object cardData = cService.getCardDetails(cardId);
        return cardData;
    }

    @GetMapping("/ok")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> ok() {
        System.out.println("ok");
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/getcards")
    @CrossOrigin(origins = "*")
    public Map<String, Object> getAllCards() {
        Map<String, Object> cardData = cService.getAllCards();
        return cardData;
    }
}
