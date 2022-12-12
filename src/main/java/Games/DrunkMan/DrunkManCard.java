package Games.DrunkMan;

import CardGame.Card;
import Enums.Games.Value;

public class DrunkManCard extends Card {

  private int score;

  public DrunkManCard(Card c) {
    super(c);
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
      case C10 -> score = 10;
      case VALET -> score = 11;
      case QUEEN -> score = 12;
      case KING -> score = 13;
      case ACE -> score = 14;
    }
  }

  public int getScore() {
    return score;
  }

  public int compareTo(DrunkManCard c) {
    if (value == Value.ACE && c.getValue() == Value.C6)  {
      return -1;
    }
    if (value == Value.C6 && c.getValue() == Value.ACE) {
      return 1;
    }
    if (score < c.getScore())
      return -1;
    if (score > c.getScore()){
      return 1;
    }
    return 0;
  }
}
