package es.maestepabaena.decksofcards;

public class ShuffleMethod {

  public void performShuffle(ShuffleStrategy shuffleStrategy, DeckOfCards deck) {
    shuffleStrategy.shuffle(deck);
  }
}
