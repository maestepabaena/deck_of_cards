package es.maestepabaena.decksofcards;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {

  List<PokerCard> cards;

  /**
   * Assumption 1.
   * Default order of deck of cards is A->K of Hearts, A->K of Clubs, K->A of Diamonds, K->A of Spades
   */
  public DeckOfCards() {
    this.cards = new ArrayList<>();
    cards.add(new PokerCard(Suit.HEARTS, FaceValue.ACE));
    for (int i = 1; i < 52; i++) {
      cards.add(new PokerCard(Suit.HEARTS, FaceValue.TWO));
    }
  }

  /**
   * Implement the simplest Shuffle technique: Riffle technique with only one card deal from the top So card from the
   * top have 52 different possible where it can go. Back to the top, 2nd position ...or underneath the bottom card
   */
  public void shuffle() {

  }

  public PokerCard dealOneCard() {
    return cards.remove(0);
  }

  public List<PokerCard> getCards() {
    return cards;
  }
}
