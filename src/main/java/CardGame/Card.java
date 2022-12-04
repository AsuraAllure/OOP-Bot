package CardGame;

import Enums.Games.Suit;
import Enums.Games.Value;

public class Card {

  protected Suit suit;
  protected Value value;
  public Card(Suit suit, Value val) {
    this.suit = suit;
    this.value = val;
  }

  public Card(Card c) {
    suit = c.suit;
    value = c.value;
  }

  public Value getValue() {
    return value;
  }

  public Suit getSuit() {
    return suit;
  }

  public String toString() {
    return suit.toString() + " " + value.toString();
  }
}
