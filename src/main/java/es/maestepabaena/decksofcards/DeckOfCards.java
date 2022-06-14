package es.maestepabaena.decksofcards;

import java.util.List;
import java.util.Stack;

public interface DeckOfCards {

  void shuffle();

  Card dealOneCard();

  Stack<Card> getCards();

}
