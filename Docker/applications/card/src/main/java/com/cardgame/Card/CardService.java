package com.cardgame.Card;

import com.cardgame.Card.CardRepo;
import com.cardgame.Card.Card;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    List<String> names = new ArrayList<String>(Arrays.asList(
        "OCEAN",
        "CAT",
        "DOG",
        "DRAGON",
        "FOREST",
        "HOUSE",
        "LION",
        "ROBOT",
        "SPACESHIP",
        "UNICORN"
    ));

    private final CardRepo cardRepo;
    private final ImgGeneratorService imgGeneratorService;
    private final PromptGeneratorService promptGeneratorService;


    public CardService(CardRepo cardRepo, ImgGeneratorService imgGeneratorService, PromptGeneratorService promptGeneratorService) {
        this.cardRepo = cardRepo;
        this.imgGeneratorService = imgGeneratorService;
        this.promptGeneratorService = promptGeneratorService;
    }

    public void generateAllCards() {
        int length = (int) cardRepo.count();
        if(length == 0){
            List<String> promptResponse = promptGeneratorService.generateAllPrompts();
            List<String> imageRequestId = imgGeneratorService.generateAllImages();

            for (int i = 0; i < promptResponse.size(); i++) {

                String familyName = names.get(i);
                String imgSrc = imageRequestId.get(i);
                String name = familyName.toLowerCase();
                String description = promptResponse.get(i);
                int hp =  (int) ((Math.random() * 1000) + 1);
                int energy = (int) ((Math.random() * 100) + 1);
                int attack = (int) ((Math.random() * 200) + 1);
                int defense = (int) ((Math.random() * 100) + 1);
                int price = (int) ((Math.random() * 1000) + 1);
                
                Card card = new Card(familyName, imgSrc, name, description, hp, energy, attack, defense, price);
                cardRepo.save(card);
            }
        }
    }

    public List<Card> generateCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            int length = (int) cardRepo.count();
            cards.add(cardRepo.findById((int) (Math.random() * length) + 1).get());
        }
        return cards;
    }

}


    