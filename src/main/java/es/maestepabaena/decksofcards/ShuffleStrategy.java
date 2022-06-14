package es.maestepabaena.decksofcards;

import java.util.concurrent.ThreadLocalRandom;

public enum ShuffleStrategy {

  SIMPLE_RIFFLE_SHUFFLE {
    @Override
    void shuffle(DeckOfCards deck) {
      Card card = deck.getCards().pop();
      deck.getCards().add(ThreadLocalRandom.current().nextInt(0, 52), card);
    }

  };

  abstract void shuffle(DeckOfCards deck);

}
