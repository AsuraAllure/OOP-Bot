package Games.BlackJack;

import CardGame.GameException;
import Enums.Games.BlackJack.PlayerState;

public class Dealer extends Player {

  public void doStep(BlackJackDeck deck) {

    if (st == PlayerState.WAIT) {
      return;
    }

    if (calcScore() >= 17) {
      waitStep();
      return;
    }


    try {
      takeCard(new BlackJackCard(deck.getCard()));
    } catch (AceException ace) {
      if (calcScore() <= 10) {
        ace.curCard.setScore(11);
      }
      ace.curCard.setScore(1);
      try {
        takeCard(ace.curCard);
      } catch (AceException a) {
        a.printStackTrace();
        throw new Error();
      }
    } catch (GameException e) {
      throw new Error();
    }


  }
}
