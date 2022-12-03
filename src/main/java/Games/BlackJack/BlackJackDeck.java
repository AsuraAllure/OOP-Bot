package Games.BlackJack;

import CardGame.Deck;
import CardGame.GameException;
import Enums.Games.TypeDeck;
import Enums.Games.Value;

public class BlackJackDeck extends Deck {
  public BlackJackDeck() throws GameException {
    super(TypeDeck.BIG);
    for (int i = 0; i <52; i++)
      super.deck[i] = new BlackJackCard(deck[i]);
  }
  public void refresh(){
    super.refresh();
    int i = 0;
    for(; i < super.size ; i++ )
      if (deck[i].getValue() == Value.ACE)
        deck[i] = new BlackJackCard(deck[i].getSuit(), deck[i].getValue());
  }
}
