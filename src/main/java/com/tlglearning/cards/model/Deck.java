package com.tlglearning.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterable<Card> {

  private final List<Card> cards;

  private Random defaultRng;

  public Deck() {
    Suit[] suits = Suit.values(); //creates array of suits
    Rank[] ranks = Rank.values(); //creates array of ranks
    cards = new ArrayList<>(suits.length * ranks.length); //creates the size of the deck used/needed
    for (Suit suit : suits) {
      for (Rank rank : ranks) {
        Card card = new Card(rank, suit); //give each card a rank and suit
        cards.add(card); //adds cards to a deck
      }
    }
  }

  public void shuffle() { //used to shuffle cards not really sure how it works
    if (defaultRng == null) {
      defaultRng = new Random();
    }
    shuffle(defaultRng);
  }

  public void shuffle(Random rng) { //used to randomize cards
    Collections.shuffle(cards, rng);
  }

  public void sort() {
    sort(null);
  }

  public void sort(Comparator<Card> comparator) { //deligates to the list of cards called cards
    cards.sort(comparator);
  }

  @Override
  public Iterator<Card> iterator() {
    return Collections.unmodifiableList(cards).iterator();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

}
