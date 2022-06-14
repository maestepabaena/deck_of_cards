package es.maestepabaena.decksofcards.model;

public enum PokerSuit implements Suit{
  SPADES("Spades"), DIAMONDS("Diamonds"), CLUBS("Clubs"), HEARTS("Hearts");

  private String value;

  PokerSuit(String value) {
    this.value=value;
  }

  @Override
  public String value() {
    return value;
  }

}
