package Games.BlackJack;

import Enums.Games.BlackJack.GameStateBlackJack;
import Enums.Games.BlackJack.PlayerState;
import CardGame.Player;

public class PlayerBlackJack extends Player {

  protected PlayerState st;
  protected GameStateBlackJack gSt;
  protected int curScore;

  public PlayerBlackJack() {
    super();
    gSt = GameStateBlackJack.NULL;
    st = PlayerState.NULL;
    curScore = 0;
  }

  public GameStateBlackJack getGST() {
    return gSt;
  }

  public int getCurScore() {
    return curScore;
  }

  public boolean isWait() {
    return st == PlayerState.WAIT;
  }

  public void refresh() {
    super.refresh();
    st = PlayerState.TAKE_CARD;
    gSt = GameStateBlackJack.ACTIVE;
    curScore = 0;
  }

  public void endStep() {
    st = PlayerState.WAIT;
  }



  public void takeCard(BlackJackCard card) throws AceException {
    super.takeCard(card);

    int a = card.getScore();
    curScore += a;
    if (curScore >= 21) {
      st = PlayerState.WAIT;
      if (curScore == 21) {
        gSt = GameStateBlackJack.BJ;
      } else {
        gSt = GameStateBlackJack.OVERFLOW;
      }
    }
  }
}
