package CardGame;

import java.util.LinkedList;
import java.util.List;


public class Player {

  protected List<Card> hand;

  public Player() {
    hand = new LinkedList<Card>();
  }

  public String showHand() {
    String res = "";
    for (Card c : hand) {
      res += c.toString() + '\n';
    }
    return res;
  }

  public void refresh() {
    hand.clear();
  }

  public Card drowCard(int a){
    Card d = hand.get(a);
    hand.remove(a);
    return d;
  }
  public void takeCard(Card card) {
    hand.add(card);
  }
}
