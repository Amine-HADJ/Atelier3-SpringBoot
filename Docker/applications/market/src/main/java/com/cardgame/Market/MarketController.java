package com.cardgame.Market;

import com.cardgame.Market.MarketRequest;
import com.cardgame.Market.MarketService;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unused")
@RestController
public class MarketController {

    private final MarketService mService;

    public MarketController(MarketService mService) {
        this.mService = mService;
    }

    @PostMapping("/buycard")
    @CrossOrigin(origins = "*")
    public void buyCard(@RequestBody MarketRequest req) {
        mService.buyCard(req.getUserId(), req.getCardId());
    }


    @PostMapping("/sellcard")
    @CrossOrigin(origins = "*")
    public void sellCard(@RequestBody MarketRequest req) {
        mService.sellCard(req.getUserId(), req.getCardId());
    }
    
    @GetMapping("/getmarket")
    @CrossOrigin(origins = "*")
    public Map<String, Object> market() {
        return mService.getCards();
    }
}