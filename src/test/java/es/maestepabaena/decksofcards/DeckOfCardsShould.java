package es.maestepabaena.decksofcards;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class DeckOfCardsShould {

  @Test
  public void return_deck_randomly_permuted_when_shuffle_isCalled() {
    //given
    DeckOfCards deckOfCards= new DeckOfCards();

    //when
    deckOfCards.shuffle();

    //then
    assertThat(deckOfCards.getCardsLeft(),is(52));

  }

}