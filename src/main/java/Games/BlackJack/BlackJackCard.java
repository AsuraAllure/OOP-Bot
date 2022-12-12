package Games.BlackJack;

import CardGame.Card;
import Enums.Games.Suit;
import Enums.Games.Value;

public class BlackJackCard extends Card {

  private int score;

  public BlackJackCard(Suit s, Value v) {
    super(s, v);
    convertValueToScore();
  }

  public BlackJackCard(Card c) {
    super(c.getSuit(), c.getValue());
    convertValueToScore();
  }

  private void convertValueToScore() {
    switch (value) {
      case C2 -> score = 2;
      case C3 -> score = 3;
      case C4 -> score = 4;
      case C5 -> score = 5;
      case C6 -> score = 6;
      case C7 -> score = 7;
      case C8 -> score = 8;
      case C9 -> score = 9;
      case C10, VALET, QUEEN, KING -> score = 10;
      case ACE -> score = -1;
    }
  }

  public int getScore() throws AceException {
    if (score == -1) {
      throw new AceException(this);
    }
    return score;
  }

  public void setScore(int sc) {
    score = sc;
  }

  @Override
  public String toString() {
    if (score != -1) {
      return super.toString() + " " + score;
    }
    return super.toString();
  }
}
