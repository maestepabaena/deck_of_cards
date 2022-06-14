package es.maestepabaena.decksofcards.model;

import es.maestepabaena.decksofcards.Card;

import java.util.Objects;

public class PokerCard implements Card {

  private Suit pokerSuit;
  private FaceValue pokerFaceValue;

  public PokerCard(PokerSuit pokerSuit, PokerFaceValue pokerFaceValue) {
    this.pokerSuit = pokerSuit;
    this.pokerFaceValue = pokerFaceValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof PokerCard))
      return false;
    PokerCard pokerCard = (PokerCard) o;
    return pokerSuit == pokerCard.pokerSuit && pokerFaceValue == pokerCard.pokerFaceValue;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pokerSuit, pokerFaceValue);
  }

  @Override
  public Suit getSuit() {
    return this.pokerSuit;
  }
  @Override
  public FaceValue getFaceValue() {
    return this.pokerFaceValue;
  }

  @Override public String toString() {
    return "PokerCard{" + "pokerSuit=" + pokerSuit + ", pokerFaceValue=" + pokerFaceValue + '}';
  }
}
