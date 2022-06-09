package es.maestepabaena.decksofcards;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

class DeckOfCardsShould {

  @Test
  public void return_deck_randomly_permuted_when_shuffle_isCalled() {
    // given
    DeckOfCards deckOfCards = new DeckOfCards();

    // when
    deckOfCards.shuffle();

    // then
    assertThat(deckOfCards.getCardsLeft(), is(52));

  }

  @Test
  public void return_oneCard_when_dealOneCard() {
    // given
    DeckOfCards deckOfCards = new DeckOfCards();

    // when
    PokerCard card = deckOfCards.dealOneCard();

    // then
    assertNotNull(card);

  }

}