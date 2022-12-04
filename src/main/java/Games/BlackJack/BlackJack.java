package Games.BlackJack;

import CardGame.GameException;
import Enums.Games.BlackJack.GameStateBlackJack;

public class BlackJack {

  private Dealer dealer;
  private User user;
   private BlackJackDeck deck;
  private Boolean gameState;
  public BlackJack() {
    try {
      deck = new BlackJackDeck();
    } catch (GameException e) {
      e.printStackTrace();
    }
    dealer = new Dealer();
    user = new User();
    gameState = false;
  }

  public void startPlay() {
    gameState = true;
    dealer.refresh();
    user.refresh();
    deck.refresh();
  }

  public void setSeed(long a){
    deck.setSeed(a);
  }
  public boolean getState() {
    return gameState;
  }

  public String distribution() {
    String mess = "Начинается партия.\nВ случае выпадение туза, введите его значение: 1 или 11\n";
    play("/take");
    mess += play("/take");
    return mess;
  }

  public String play(String input) {
    user.doStep(input, deck);
    if (isCommand(input)) {
      dealer.doStep(deck);
    }
    if (user.isWait()) {
      finishDealerStep();
    }
    roundCheck();
    return loggingStep(input);
  }

  private void roundCheck() {
    if (dealer.isWait() && dealer.gSt == GameStateBlackJack.OVERFLOW
        && user.gSt != GameStateBlackJack.OVERFLOW) {
      user.endStep();
    }

    gameState = dealer.isWait() && user.isWait();
  }

  private String loggingStep(String input) {

    if (user.hasAce()) {
      return "Ваши карты:\n" + user.showHand() + "Вам выпал " + user.getAce().toString()
          + ". Определите его значение 1/11";
    }

    String stepMessage =
        "Dealer:\n" + dealer.showHand() + "Счет Ведущего: " + dealer.calcScore() + "\nUser:\n"
            + user.showHand() + "Счет Игрока: " + user.calcScore();

    if (!gameState) {
      return stepMessage + "\n/wait - остановить добор , /take - добрать карту";
    }

    String mes = stepMessage + ". Cчёт ведущего: " + dealer.calcScore();

    switch (compare(user, dealer)) {
      case 1:
        if (user.calcScore() != 21) {
          return mes + " Вы выйграли.";
        }
        return mes + " Вы выйграли, у вас Блэкджек. Поздравляем.";
      case 2:
        return mes + " Вы проиграли.";
      case 3:
        return mes + " Ничья.";
    }
    return "error";
  }

  private int compare(Player us, Player deal) {
    if (us.getGST() != GameStateBlackJack.OVERFLOW) {
      if (us.calcScore() > deal.calcScore() || deal.getGST() == GameStateBlackJack.OVERFLOW) {
        return 1;
      }
    }
    if (deal.calcScore() == us.calcScore()) {
      return 3;
    }
    return 2;
  }

  private boolean isCommand(String input) {
    return input.contentEquals("/wait") || input.contentEquals("/take");
  }

  private void finishDealerStep() {
    while (!dealer.isWait()) {
      dealer.doStep(deck);
    }
  }

  public void refresh() {
    user.refresh();
    dealer.refresh();
    deck.refresh();
    gameState = false;
  }
}
