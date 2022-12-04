package CardGame;

import Enums.Games.Suit;
import Enums.Games.TypeDeck;
import Enums.Games.Value;
import java.util.Date;
import java.util.Random;

public class Deck {

  protected final Card[] deck;
  protected final int size;
  protected long seed;
  private int countUsing;

  public Deck(TypeDeck sizeDeck) {
    if (sizeDeck == TypeDeck.SMALL) {
      size = 36;
    } else {
      size = 52;
    }
    deck = new Card[size];
    countUsing = 0;
    seed = -1;
    initDeck();
    shuffle();
  }

  private void initDeck() {
    boolean flagDeck = size == 52;
    int sizeSet = (size == 52) ? 13 : 9;
    Value[] valueSet = new Value[sizeSet];
    int i = 0;
    for (Value v : Value.values()) {
      if (flagDeck) {
        valueSet[i] = v;
        i++;
      } else if (v == Value.C5) {
        flagDeck = true;
      }
    }
    i = 0;
    for (Suit s : Suit.values()) {
      for (Value v : valueSet) {
        deck[i] = new Card(s, v);
        i++;
      }
    }
  }

  public Card getCard() throws EmptyDeck {
    countUsing += 1;
    if (countUsing >= size + 1) {
      throw new EmptyDeck();
    }
    return deck[countUsing - 1];
  }

  // Математически обоснованное равномерное распределение.
  private void shuffle() {
    Random genR;
    if (seed == -1) {
      genR = new Random(new Date().getTime());
    } else {
      genR = new Random(seed);
    }
    for (int i = 0; i < size; i++) {
      Card temp = new Card(deck[i]);
      int j = genR.nextInt(size - 1);
      deck[i] = deck[j];
      deck[j] = temp;
    }
  }

  public void refresh() {
    shuffle();
    countUsing = 0;
  }

  public void setSeed(long a) {
    seed = a;
    initDeck();
    shuffle();
  }

  public void printDeck() {
    for (int i = 0; i < size; i++) {
      System.out.println(deck[i].toString());
    }
  }
}
