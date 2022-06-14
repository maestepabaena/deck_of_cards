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

import es.maestepabaena.decksofcards.model.FaceValue;
import es.maestepabaena.decksofcards.model.PokerCard;
import es.maestepabaena.decksofcards.model.Suit;

class DeckOfCardsShould {

  private DeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    deckOfCards = new DeckOfCards();
  }

  @Test
  void return_52cards_inTheDefaultOrder() {
    // then
    for (Suit suit : Suit.values()) {
      for (FaceValue faceValue : FaceValue.values()) {
        PokerCard card = deckOfCards.dealOneCard();
        assertThat(card.getSuit()).isEqualTo(suit);
        assertThat(card.getFaceValue()).isEqualTo(faceValue);
      }
    }

  }

  @Test
  void return_deck_randomly_permuted_when_shuffle_isCalled() {
    // when
    deckOfCards.shuffle();

    // then
    assertThat(deckOfCards.getCards().size(), is(52));

  }

  @Test
  void return_oneCard_when_dealOneCard() {
    // when
    PokerCard card = deckOfCards.dealOneCard();

    // then
    assertNotNull(card);
    assertThat(deckOfCards.getCards().size(), is(51));

  }

  @Test
  void return_twoDifferentCards_when_dealOneCardIsCalledTwice() {
    // when
    PokerCard firstCard = deckOfCards.dealOneCard();
    PokerCard secondCard = deckOfCards.dealOneCard();

    // then
    assertNotNull(firstCard);
    assertNotNull(secondCard);
    assertThat(deckOfCards.getCards().size(), is(50));
    assertThat(firstCard).isNotEqualTo(secondCard);

  }

  @Test
  void return_differentCards_when_dealOneCardIsCalled52Times() {
    // given
    List<PokerCard> callerCards = new ArrayList<>();

    // when
    for (int i = 0; i < 52; i++) {
      callerCards.add(deckOfCards.dealOneCard());
    }

    // then
    Set<PokerCard> duplicatesCards = findDuplicateByFrequency(callerCards);
    assertThat(duplicatesCards.size()).isEqualTo(0);
    assertThat(callerCards.size()).isEqualTo(52);
  }

  private Set<PokerCard> findDuplicateByFrequency(List<PokerCard> callerCards) {
    return callerCards.stream().filter(i -> Collections.frequency(callerCards, i) > 1).collect(Collectors.toSet());
  }

  @Test
  void return_null_when_dealOneCardIsCalled53Times() {
    // when
    for (int i = 0; i < 52; i++) {
      deckOfCards.dealOneCard();
    }
    PokerCard card53th = deckOfCards.dealOneCard();

    // then
    assertThat(card53th).isNull();
  }

}