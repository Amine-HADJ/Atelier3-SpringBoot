package com.cardgame.Card;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cardgame.Card.Card;


@Repository
public interface CardRepo extends CrudRepository<Card, Integer> {
    List<Card> findByFamilyName(String familyName);
    List<Card> findAll();
}



