package es.maestepabaena.decksofcards;

import es.maestepabaena.decksofcards.model.FaceValue;
import es.maestepabaena.decksofcards.model.PokerCard;
import es.maestepabaena.decksofcards.model.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {

  List<PokerCard> cards;

  /**
   * Assumption 1.
   * Default order of deck of cards is A->K of Spades, A->K of Diamonds, A->K of Clubs , A->K of Hearts
   */
  public DeckOfCards() {
    this.cards = new ArrayList<>();

    for (Suit suit : Suit.values()) {
      for (FaceValue faceValue : FaceValue.values()) {
        PokerCard pokerCard = new PokerCard(suit, faceValue);
        cards.add(pokerCard);
      }
    }
  }

  /**
   * Implement the simplest Shuffle technique: Riffle technique with only one card deal from the top So card from the
   * top have 52 different possible where it can go. Back to the top, 2nd position ...or underneath the bottom card
   */
  public void shuffle() {
    PokerCard card=cards.remove(0);
    cards.add(randomNumberFrom0to52(),card);
  }

  private int randomNumberFrom0to52() {
    return ThreadLocalRandom.current().nextInt(0, 52);
  }

  public PokerCard dealOneCard() {
    return cards.remove(0);
  }

  public List<PokerCard> getCards() {
    return cards;
  }
}
