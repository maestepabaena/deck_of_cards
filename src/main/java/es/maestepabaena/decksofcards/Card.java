package es.maestepabaena.decksofcards;

import es.maestepabaena.decksofcards.model.FaceValue;
import es.maestepabaena.decksofcards.model.Suit;

public interface Card {

        Suit getSuit();
        FaceValue getFaceValue();
}
