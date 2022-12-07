package Games.BlackJack;

import CardGame.GameException;
import Enums.Games.BlackJack.PlayerState;


public class User extends Player {

  private boolean hasAceVal;
  private BlackJackCard prevCard;

  public User() {
    hasAceVal = false;
  }

  public BlackJackCard getAce() {
    return prevCard;
  }

  public void doStep(String choice, BlackJackDeck deck) {
    if (st == PlayerState.WAIT) {
      return;
    }

    if (choice.contentEquals("/wait") || choice.contentEquals("wait")) {
      st = PlayerState.WAIT;
      return;
    }
    if (choice.contentEquals("/take") || choice.contentEquals("take")) {
      try {
        takeCard(new BlackJackCard(deck.getCard()));
      } catch (AceException e) {
        hasAceVal = true;
        prevCard = e.curCard;
      } catch (GameException e) {
        throw new Error();
      }
      return;
    }
    hasAceVal = false;
    prevCard.setScore(convertToInt(choice));
    try {
      takeCard(prevCard);
    } catch (GameException a) {
      throw new Error();
    }
  }

  public boolean hasAce() {
    return hasAceVal;
  }

  private int convertToInt(String in) {
    return in.contentEquals("1") ? 1 : 11;
  }
}
