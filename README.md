# Deck of Cards Problem Statement

Your assignment is to code a set of classes that represent a deck of poker-style playing cards.
(Fifty-two playing cards in four suits: hearts, spades, clubs, diamonds, with face values of Ace, 2-10, Jack, Queen, and
King.)

Within one of your classes, you must provide two operations:

1. shuffle() Shuffle returns no value, but results in the cards in the deck being randomly permuted. Please do not use
   library-provided “shuffle” operations to implement this function. You may use library provided random number
   generators in your solution if needed.

2. dealOneCard() This function should return one card from the deck to the caller. Specifically, a call to shuffle
   followed by 52 calls to dealOneCard() should result in the caller being provided all 52 cards of the deck in a random
   order. If the caller then makes a 53rd call dealOneCard(), no card is dealt.

Many details of this assignment have been left intentionally vague.

Follow the principle of the least surprise in making reasonable decisions regarding the implementation. While this is a
trivial assignment, pretend that this code will become a foundational part of a new product.Take whatever measures you
feel are required for your code to meet this bar. We are not concerned with how quickly you complete this assignment.
Take your time and do it right!

# Assumptions

We will give here some assumptions for some aspect of the statement that have been left intentionally vague. Initially
we will assume the most basic ways to accomplish the call

1- Order of cards before do any shuffle (fresh deck when you buy it)?: We assume the order is A->K of Hearts, A->K of
Clubs, K->A of Diamonds, K->A of Spades based on real case: https://ambitiouswithcards.com/new-deck-order/

2- How many cards are permuted randomly in each shuffle() call? There are exactly 52 factorial possible orderings of the
cards (that is a lot!) . So we can conclude it's almost impossible to know (and test) how many cards has been changed
from their initial position in the deck if we do a perfect random shuffle. But there are also different shuffle
techniques based on
https://en.wikipedia.org/wiki/Shuffling. Depends on the shuffle technique we could do some probabilist predictions about
randomness level of the deck. So for this exercise we will assume to always do the simplest shuffle possible (take the top card off and put in
a random order, it's like riffle shuffle with one card) and only once.

3- How many times we do a shuffle in a game. We will assume we always shuffle at the beginning (fresh deck in a default
order) and then we can deal a card from the top until we don't have more cards (we will not shuffle with less than 52
cards in the decks)

