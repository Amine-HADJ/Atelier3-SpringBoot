package com.cardgame.Market;

import org.springframework.stereotype.Service;

import com.cardgame.Market.Card;
import com.cardgame.Market.CardRepo;
import com.cardgame.Market.UserRepo;

import java.util.List;


@Service
public class MarketService {

    private CardRepo cardRepo;
    private UserRepo userRepo;

    public MarketService(CardRepo cardRepo, UserRepo userRepo) {
        this.cardRepo = cardRepo;  
        this.userRepo = userRepo;
    }

    public void buyCard(Integer userId, int cardId) {
        /*
        Inventory userInventoy = inventoryRepo.findById(userId).get();
        List<Card> useCards = userInventoy.getCards();
        
        // Check if the user has the card
        if (useCards.contains(cardRepo.findById(cardId).get())) {
            System.out.println("User already has the card");
            return;
        }
        
        userRepo.findById(userId).get().setWallet( -cardRepo.findById(cardId).get().getPrice());

        // on save le wallet dans la database
        userRepo.save(userRepo.findById(userId).get());

        // on supprime la carte de l'inventaire
        useCards.add(cardRepo.findById(cardId).get());
        userInventoy.setCards(useCards);
        inventoryRepo.save(userInventoy);
        */
    }

    public void sellCard(Integer userId, int cardId) {
        /*
            Inventory userInventoy = inventoryRepo.findById(userId).get();
            List<Card> useCards = userInventoy.getCards();
            
            // Check if the user has the card
            if (!useCards.contains(cardRepo.findById(cardId).get())) {
                System.out.println("User does not have the card");
                return;
            }
            System.out.println("User has the card");
            userRepo.findById(userId).get().setWallet(cardRepo.findById(cardId).get().getPrice());

            // on save le wallet dans la database
            userRepo.save(userRepo.findById(userId).get());

            // on supprime la carte de l'inventaire
            useCards.remove(cardRepo.findById(cardId).get());
            userInventoy.setCards(useCards);
            inventoryRepo.save(userInventoy);
            */
    }

    public List<Card> getCards() {
        return cardRepo.findAll();
    }

}