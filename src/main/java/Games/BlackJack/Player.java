package Games.BlackJack;

import Enums.Games.BlackJack.GameStateBlackJack;
import Enums.Games.BlackJack.PlayerState;
import java.util.LinkedList;
import java.util.List;

public class Player {

  protected List<BlackJackCard> hand;
  protected PlayerState st;
  protected GameStateBlackJack gSt;
  protected int curScore;

  public Player() {
    hand = new LinkedList<BlackJackCard>();
    gSt = GameStateBlackJack.NULL;
    st = PlayerState.NULL;
    curScore = 0;
  }

  public GameStateBlackJack getGST() {
    return gSt;
  }

  public String showHand() {
    String res = "";
    for (BlackJackCard c : hand) {
      res += c.toString() + '\n';
    }
    return res;
  }

  public int calcScore() {
    return curScore;
  }

  public boolean isWait() {
    return st == PlayerState.WAIT;
  }

  public void refresh() {
    hand.clear();
    st = PlayerState.TAKE_CARD;
    gSt = GameStateBlackJack.ACTIVE;
    curScore = 0;
  }

  public void endStep() {
    st = PlayerState.WAIT;
  }

  public void takeCard(BlackJackCard card) throws AceException {
    int a = card.getScore();
    hand.add(card);
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
