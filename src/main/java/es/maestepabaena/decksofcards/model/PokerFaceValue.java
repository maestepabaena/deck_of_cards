package es.maestepabaena.decksofcards.model;

public enum PokerFaceValue implements FaceValue {
  ACE("Ace"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"), SIX("Six"), SEVEN("Seven"), EIGHT("Eight"), NINE(
      "Nine"), TEN("Ten"), JACK("Jack"), QUEEN("Queen"), KING("King");

  private String value;

  @Override
  public String value() {
    return value;
  }

  PokerFaceValue(String value){
    this.value=value;
  }
}
