package Games.BlackJack;

import CardGame.GameException;

public class AceException extends GameException {

  public BlackJackCard curCard;

  AceException(BlackJackCard c) {
    curCard = c;
  }
}
