package Games.DrunkMan;

import CardGame.GameException;
import java.util.LinkedList;
import java.util.List;

public class DrunkMan {
  private PlayerDrunkMan dealer;
  private PlayerDrunkMan user;
  private DrunkManDeck deck;
  List<DrunkManCard> table;
  private boolean isInit;
  private boolean userWin;
  private Boolean gameState;


  public DrunkMan(){
    try {
      deck = new DrunkManDeck();
    } catch (GameException e) {
      e.printStackTrace();
    }
    dealer = new PlayerDrunkMan();
    user = new PlayerDrunkMan();
    gameState = false;
    isInit = false;
    userWin = false;
    table = new LinkedList<DrunkManCard>();

  }
  public void startPlay() {
    gameState = true;
    userWin = false;
    isInit = false;
    dealer.refresh();
    user.refresh();
    deck.refresh();
    table.clear();
  }
  public void setSeed(long a) {
    deck.setSeed(a);
  }
  public boolean getState() {
    return gameState;
  }
  public void refresh() {
    dealer.refresh();
    user.refresh();
    deck.refresh();
    table.clear();
    gameState = false;
    userWin = false;
    isInit = false;
  }
  public String play(){

    if (!isInit) {
      startPlay();
      init(user, dealer);
      isInit = true;
    }
    table.clear();
      while (true) {
        DrunkManCard d1 = user.drowCard();
        DrunkManCard d2 = dealer.drowCard();
        table.add(d1);
        table.add(d2);

        if (d1.compareTo(d2) != 0) {
          userWin = (d1.compareTo(d2)) != -1;
          break;
        }
        if (user.getCountCard() == 0 || dealer.getCountCard() == 0) {
          userWin = true;
          break;
        }
      }

      for(DrunkManCard c : table)
        if (userWin)
          user.takeCard(c);
        else
          dealer.takeCard(c);

    roundCheck();
    return loggingStep();
  }
  private String loggingStep(){
    String mes = "";

    for (int i=0; i < table.size(); i++)
      mes += table.get(i).toString()+'\n';

    if (gameState){
      if (userWin)
        mes += "Вы выйграли раунд";
      else
        mes += "Вы проиграли раунд";

      mes += "\nУ вас " + user.getCountCardStr()+ "\nУ ведущего " + dealer.getCountCardStr();
      return mes;
    }

    if (userWin)
      return mes + "\nВы выйграли, поздравляем";
    return mes + "\nВы проиграли";
  }

  private void init(PlayerDrunkMan u, PlayerDrunkMan d){
      for (int i=0; i < 18; i++) {
        try {
          u.takeCard(deck.getCard());
          d.takeCard(deck.getCard());
        }catch (GameException e){
          e.printStackTrace();
          throw new Error();
        }
      }
  }

  private void roundCheck(){
    gameState =  !(user.isWin() || dealer.isWin());
  }
}
