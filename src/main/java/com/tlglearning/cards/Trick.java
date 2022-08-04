package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Suit;
import com.tlglearning.cards.model.Suit.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Trick {

  private static final String TALLY_FORMAT = "%1$s pile contains %2$d %1$s cards. %3$s.%n";

  public static void main(String[] args) {
    //DONE Create instance of Deck and shuffle it.
    Random rng = new SecureRandom();
    Deck deck = buildDeck(rng);
    //DONE Draw cards from the deck until none remain, and split the cards into red and black piles.
    List<Card> blackPile = new ArrayList<>(); //Lists out all black cards
    List<Card> redPile = new ArrayList<>();  //lists out all red cards
    splitDeck(deck, blackPile, redPile);
    //DONE Swap a random number of cards between red and black piles.
    swapCards(rng, blackPile, redPile);
    //TODO tally count of red cards in red pile, black cards in black pile, and print results.
    tallyPiles(blackPile, redPile);
  }

  private static Deck buildDeck(Random rng) {
    Deck deck = new Deck();
    deck.shuffle(rng);
    return deck;
  }

  private static void splitDeck(Deck deck, List<Card> blackPile, List<Card> redPile) {
    while (!deck.isEmpty()) {
      Card indicator = deck.draw();
      Card next = deck.draw();
      if (indicator.getSuit().getColor() == Color.BLACK) {
        blackPile.add(next);
      }else {
        redPile.add(next);
      }
    }
  }

  private static void swapCards(Random rng, List<Card> blackPile, List<Card> redPile) {
    int swapCount = rng.nextInt(1 + Math.min(blackPile.size(), redPile.size())); //swap cards from black and red
    for (int i = 0; i < swapCount; i++) {
      redPile.add(blackPile.remove(0));  //add a card to red pile then remove one from the top
      blackPile.add(redPile.remove(0));
    }
  }

  private static void tallyPiles(List<Card> blackPile, List<Card> redPile) {
    int blackCount = (int) blackPile  //creates a pile of black cards
        .stream()
        .filter((card) -> card.getSuit().getColor() == Color.BLACK)
        .count();
    blackPile.sort(  //sort by color then natural order
        Comparator
            .comparing(Card::getSuit, Comparator.comparing(Suit::getColor))
            .thenComparing(Comparator.naturalOrder())
    );
    int redCount = (int) redPile  //creates a pile of red cards
        .stream()
        .filter((card) -> card.getSuit().getColor() == Color.RED)
        .count();
    redPile.sort(  //sort by color then natural order
        Comparator
            .comparing(Card::getSuit, Comparator.comparing(Suit::getColor).reversed())
            .thenComparing(Comparator.naturalOrder())
    );
    //  %1$s = Black  %2$s = count %3$s = pile
    System.out.printf(TALLY_FORMAT, Color.BLACK, blackCount, blackPile);
    System.out.printf(TALLY_FORMAT, Color.RED, redCount, redPile);
  }

}

