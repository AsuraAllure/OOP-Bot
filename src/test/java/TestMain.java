import CardGame.GameException;
import Enums.Games.Value;
import Games.BlackJack.BlackJackDeck;

public class TestMain {
  public static void main(String[] args){
    for (int i=0 ; i < 16; i++) {
      BlackJackDeck deck;
      try {
        deck = new BlackJackDeck();
      } catch (GameException g) {
        deck = null;
      }
      ;
      deck.setSeed(i);
      try {
        if (deck.getCard().getValue() == Value.ACE)
          deck.printDeck();
      } catch (GameException g) {
      }

    }
  }
}
