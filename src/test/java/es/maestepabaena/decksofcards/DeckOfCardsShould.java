package es.maestepabaena.decksofcards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.maestepabaena.decksofcards.model.PokerFaceValue;
import es.maestepabaena.decksofcards.model.PokerSuit;

class DeckOfCardsShould {

  private PokerDeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    deckOfCards = new PokerDeckOfCards();
  }

  @Test
  void return_52cards_inTheDefaultOrder() {
    // then
    for (PokerSuit suit : PokerSuit.values()) {
      for (PokerFaceValue faceValue : PokerFaceValue.values()) {
        Card card = deckOfCards.dealOneCard();
        assertThat(card.getSuit()).isEqualTo(suit);
        assertThat(card.getFaceValue()).isEqualTo(faceValue);
      }
    }
  }

  @Test
  void return_deck_randomly_permuted_when_shuffle_isCalled() {
    // given
    PokerDeckOfCards brandNewDeck = new PokerDeckOfCards();

    // when
    deckOfCards.shuffle();

    // then
    assertThat(deckOfCards.getCards().size(), is(52));
    assertThat(deckOfCards.getCards()).isNotEqualTo(brandNewDeck.getCards());

  }

  @Test
  void return_oneCard_when_dealOneCard() {
    // when
    Card card = deckOfCards.dealOneCard();

    // then
    assertNotNull(card);
    assertThat(deckOfCards.getCards().size(), is(51));

  }

  @Test
  void return_twoDifferentCards_when_dealOneCardIsCalledTwice() {
    // when
    Card firstCard = deckOfCards.dealOneCard();
    Card secondCard = deckOfCards.dealOneCard();

    // then
    assertNotNull(firstCard);
    assertNotNull(secondCard);
    assertThat(deckOfCards.getCards().size(), is(50));
    assertThat(firstCard).isNotEqualTo(secondCard);

  }

  @Test
  void return_differentCards_when_dealOneCardIsCalled52Times() {
    // given
    List<Card> callerCards = new ArrayList<>();

    // when
    for (int i = 0; i < 52; i++) {
      callerCards.add(deckOfCards.dealOneCard());
    }

    // then
    Set<Card> duplicatesCards = findDuplicateByFrequency(callerCards);
    assertThat(duplicatesCards.size()).isZero();
    assertThat(callerCards.size()).isEqualTo(52);
  }

  @Test
  void return_null_when_dealOneCardIsCalled53Times() {
    // when
    for (int i = 0; i < 52; i++) {
      deckOfCards.dealOneCard();
    }
    Card card53th = deckOfCards.dealOneCard();

    // then
    assertThat(card53th).isNull();
  }

  private Set<Card> findDuplicateByFrequency(List<Card> callerCards) {
    return callerCards.stream().filter(i -> Collections.frequency(callerCards, i) > 1).collect(Collectors.toSet());
  }

}