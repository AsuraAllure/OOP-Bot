package Games.DrunkMan;

import CardGame.Deck;
import CardGame.GameException;
import Enums.Games.TypeDeck;
import Enums.Games.Value;

public class DrunkManDeck extends Deck {

  public DrunkManDeck() throws GameException {
    super(TypeDeck.SMALL);
    for (int i = 0; i < 36; i++) {
      super.deck[i] = new DrunkManCard(deck[i]);
    }
  }
  public void refresh() {
    super.refresh();
    int i = 0;
    for (; i < super.size; i++) {
      if (deck[i].getValue() == Value.ACE) {
        deck[i] = new DrunkManCard(deck[i]);
      }
    }
  }

}
