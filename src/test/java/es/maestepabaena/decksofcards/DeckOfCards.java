package es.maestepabaena.decksofcards;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {

  List<String> cards;

  public DeckOfCards() {
    this.cards = new ArrayList<>();
  }

  public void shuffle() {

  }

  public int getCardsLeft() {
    return 52;
  }

  public PokerCard dealOneCard() {
    return new PokerCard();
  }
}
