package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

public class TestMain {

  public static void main(String[] args) {
    Deck deck = new Deck();
    Random rng = new SecureRandom();
    System.out.println(deck);
    deck.shuffle(rng); //shuffle deck randomly
    System.out.println(deck);
//    for (Card card : deck) { //print cards in a vertical line
//      System.out.println(card);
//    }

    deck.sort();
    System.out.println(deck); //Sort by rank

    deck.sort(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit));
    System.out.println(deck);

  }

}
