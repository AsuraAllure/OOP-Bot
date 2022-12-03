package Games.BlackJack;

import CardGame.GameException;
import CardGame.Card;

public class AceException extends GameException {
    public BlackJackCard curCard;
    AceException(BlackJackCard c){
      curCard = c;
    }
}
