package Games.BlackJack;

import CardGame.GameException;
import Enums.Games.BlackJack.PlayerState;

public class DealerBlackjack extends PlayerBlackJack {

  public void doStep(BlackJackDeck deck) {

    if (st == PlayerState.WAIT) {
      return;
    }

    if (getCurScore() >= 17) {
      endStep();
      return;
    }

    try {
      takeCard(new BlackJackCard(deck.getCard()));
    } catch (AceException ace) {
      if (getCurScore() <= 10) {
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
