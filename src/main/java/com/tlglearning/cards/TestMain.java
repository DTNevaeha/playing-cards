package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Rank;
import java.security.SecureRandom;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestMain {

  public static void main(String[] args) {
    Deck deck = new Deck(); //creates a new deck
    Random rng = new SecureRandom();  // creates a random shuffle
    Set<Rank> exclutedCards = EnumSet.range(Rank.TWO, Rank.EIGHT); //excludes cards 2-8
    deck.shuffle(rng);  //shuffles the cards randomly
    Spliterator<Card> splitter = Spliterators.spliterator(deck.iterator(), deck.size(), 0);
        List<Card> pinochleCards = StreamSupport
        .stream(splitter, false)
        .filter((card) -> !exclutedCards.contains(card.getRank())) //allows all cards not excluded.
        .collect(Collectors.toList());
    System.out.println(pinochleCards);
  }

}
