package com.cardgame.Market;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("unchecked")
public class MarketService {

    private final RestTemplate restTemplate;
    private final String userServiceUrl = "http://user/";
    private final String cardServiceUrl = "http://card/";

    public MarketService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getAppUser() {
        return restTemplate.getForObject(userServiceUrl, Map.class);
    }

    private boolean isCardInUserCards(Integer userId, int cardId) {
        String URL = userServiceUrl+"users/{userId}/cards";
        List<Map<String, Object>> userCards = restTemplate.getForObject(URL, List.class, userId);

        return userCards.stream()
                .anyMatch(card -> ((Number) card.get("id")).longValue() == cardId);
    }

    public void buyCard(Integer userId, int cardId) {
        boolean isCardInUserCards = isCardInUserCards(userId, cardId);
        if (isCardInUserCards) { return; }

        String userUrl = userServiceUrl+"users/{userId}";
        String cardUrl = cardServiceUrl+"cards/{cardId}";
        Map<String, Object> userData = restTemplate.getForObject(userUrl, Map.class, userId);
        Map<String, Object> cardData = restTemplate.getForObject(cardUrl, Map.class, cardId);
        double walletBalance = (double) userData.get("wallet");
        double cardPrice = (double) cardData.get("price");

        if(walletBalance < cardPrice) {
            System.out.println("Not enough money to buy the card");
            return;
        }

        String buyUrl = userServiceUrl+"wallet";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("userId", userId);
        requestBody.put("price", -cardPrice);
        restTemplate.postForObject(buyUrl, requestBody, String.class);
    }

    public void sellCard(Integer userId, int cardId) {
        boolean isCardInUserCards = isCardInUserCards(userId, cardId);
        if (!isCardInUserCards) { return; }

        String cardUrl = cardServiceUrl+"cards/{cardId}";
        Map<String, Object> cardData = restTemplate.getForObject(cardUrl, Map.class, cardId);
        double cardPrice = (double) cardData.get("price");

        String buyUrl = userServiceUrl+"wallet";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("userId", userId);
        requestBody.put("price", cardPrice);
        restTemplate.postForObject(buyUrl, requestBody, String.class);
    }

    public Map<String, Object> getCards() {
        String cardUrl = cardServiceUrl+"getcards/";
        Map<String, Object> cards = restTemplate.getForObject(cardUrl, Map.class);
        return cards;
    }
}