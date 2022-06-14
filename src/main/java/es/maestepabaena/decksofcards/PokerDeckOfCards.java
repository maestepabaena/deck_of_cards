package es.maestepabaena.decksofcards;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import es.maestepabaena.decksofcards.model.PokerFaceValue;
import es.maestepabaena.decksofcards.model.PokerCard;
import es.maestepabaena.decksofcards.model.PokerSuit;

public class PokerDeckOfCards implements DeckOfCards {

  List<Card> cards;

  /**
   * Assumption 1. Default order of deck of cards is A->K of Spades, A->K of Diamonds, A->K of Clubs , A->K of Hearts
   */
  public PokerDeckOfCards() {
    this.cards = new ArrayList<>();

    for (PokerSuit pokerSuit : PokerSuit.values()) {
      for (PokerFaceValue pokerFaceValue : PokerFaceValue.values()) {
        PokerCard pokerCard = new PokerCard(pokerSuit, pokerFaceValue);
        cards.add(pokerCard);
      }
    }
  }

  /**
   * Implement the simplest Shuffle technique: Riffle technique with only one card deal from the top So card from the
   * top have 52 different possible where it can go. Back to the top, 2nd position ...or underneath the bottom card
   */
  public void shuffle() {
    Card card = cards.remove(0);
    cards.add(randomNumberFrom0to52(), card);
  }

  private int randomNumberFrom0to52() {
    return ThreadLocalRandom.current().nextInt(0, 52);
  }

  @Override
  public Card dealOneCard() {
    try {
      return cards.remove(0);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public List<Card> getCards() {
    return cards;
  }
}
