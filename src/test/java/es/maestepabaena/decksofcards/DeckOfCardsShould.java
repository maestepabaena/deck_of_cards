package es.maestepabaena.decksofcards;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckOfCardsShould {

  private DeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    deckOfCards = new DeckOfCards();
  }

  @Test
  void return_deck_randomly_permuted_when_shuffle_isCalled() {
    // when
    deckOfCards.shuffle();

    // then
    assertThat(deckOfCards.getCardsLeft(), is(52));

  }

  @Test
  void return_oneCard_when_dealOneCard() {
    // when
    PokerCard card = deckOfCards.dealOneCard();

    // then
    assertNotNull(card);

  }

}