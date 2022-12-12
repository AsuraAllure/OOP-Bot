package Games.DrunkMan;
import CardGame.Player;
import CardGame.Card;

public class PlayerDrunkMan extends Player {

  private int curCountCard;

  public PlayerDrunkMan(){
    super();
    curCountCard = 0;
  }
  public int getCountCard(){
    return hand.size();
  }
  public String getCountCardStr(){
    return Integer.toString(hand.size())+" карт";
  }
  public boolean isWin(){
    return curCountCard == 36;
  }
  public void refresh() {
  super.refresh();
  curCountCard = 0;
  }
  public DrunkManCard drowCard(){
    curCountCard -= 1;
    return new DrunkManCard(super.drowCard(hand.size()-1));
  }
  public void takeCard(Card c){
    Card car = c;
   hand.add(0,car);
   curCountCard +=1;
  }
}
