package es.maestepabaena.decksofcards;

import java.util.Objects;

public class PokerCard {
  private String suit;
  private String faceValue;

  public PokerCard(String suit,String faceValue) {
    this.suit = suit;
    this.faceValue=faceValue;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof PokerCard))
      return false;
    PokerCard pokerCard = (PokerCard) o;
    return suit.equals(pokerCard.suit) && faceValue.equals(pokerCard.faceValue);
  }

  @Override public int hashCode() {
    return Objects.hash(suit, faceValue);
  }
}
