package es.maestepabaena.decksofcards;

import java.util.List;

public interface DeckOfCards {

  void shuffle();

  Card dealOneCard();

  List<Card> getCards();

}
