package es.maestepabaena.decksofcards;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {

  List<PokerCard> cards;

  public DeckOfCards() {
    this.cards = new ArrayList<>();
    for (int i=0; i<52; i++){
      cards.add(new PokerCard("Hearts","Ace"));
    }
  }

  public void shuffle() {

  }

  public int getCardsLeft() {
    return cards.size();
  }

  public PokerCard dealOneCard() {
    cards.remove(0);
    return new PokerCard("Hearts","Ace");
  }
}
