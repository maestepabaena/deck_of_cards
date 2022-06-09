package es.maestepabaena.decksofcards.model;

import java.util.Objects;

public class PokerCard {

  private Suit suit;
  private FaceValue faceValue;

  public PokerCard(Suit suit, FaceValue faceValue) {
    this.suit = suit;
    this.faceValue = faceValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof PokerCard))
      return false;
    PokerCard pokerCard = (PokerCard) o;
    return suit == pokerCard.suit && faceValue == pokerCard.faceValue;
  }

  @Override
  public int hashCode() {
    return Objects.hash(suit, faceValue);
  }

  public Suit getSuit() {
    return this.suit;
  }

  public FaceValue getFaceValue() {
    return this.faceValue;
  }
}
