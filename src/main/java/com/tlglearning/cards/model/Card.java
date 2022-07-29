package com.tlglearning.cards.model;

import java.util.Objects;

public final class Card implements Comparable<Card> {

  private final Rank rank;
  private final Suit suit;
  private final String representation;
  private final int hash;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
    representation = rank.getSymbol() + suit.getSymbol();
    hash = Objects.hash(rank,suit);
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public int hashCode() { //Unsure of what hashcode is
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;
    if (this == obj) {  //Unsure of what this is doing
      result = true;
    } else if (obj instanceof Card) {
      Card other = (Card) obj;
      result = (rank == other.rank && suit == other.suit); //check to see if rank and suit are the same
    } else {
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    return representation;
  }

  @Override
  public int compareTo(Card other) {
    int comparison = suit.compareTo(other.suit);
    if (comparison == 0) {
      comparison = rank.compareTo(other.rank);
    }
    return comparison;
  }

}
