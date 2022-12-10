package Games.BlackJack;

import CardGame.GameException;

import Enums.Games.BlackJack.GameStateBlackJack;

public class BlackJack {

  private final DealerBlackjack dealerBlackjack;
  private final UserBlackjack userBlackjack;
  private BlackJackDeck deck;
  private Boolean gameState;

  public BlackJack() {
    try {
      deck = new BlackJackDeck();
    } catch (GameException e) {
      e.printStackTrace();
    }
    dealerBlackjack = new DealerBlackjack();
    userBlackjack = new UserBlackjack();
    gameState = false;
  }

  public void startPlay() {
    gameState = true;
    dealerBlackjack.refresh();
    userBlackjack.refresh();
    deck.refresh();
  }

  public void setSeed(long a) {
    deck.setSeed(a);
  }

  public boolean getState() {
    return gameState;
  }

  public String distribution() {
    String mess = "Начинается партия.\nВ каждой строке будет отображаться карта в формате:\nМАСТЬ ЗНАЧЕНИЕ НОМИНАЛ\n\nВ случае выпадение туза, введите его значение: 1 или 11\n\n";
    userBlackjack.doStep("/take", deck);
    dealerBlackjack.doStep(deck);
    if (userBlackjack.hasAce()) {
      roundCheck();
      return mess + loggingStep();
    }
    userBlackjack.doStep("/take", deck);
    dealerBlackjack.doStep(deck);
    roundCheck();
    return mess + loggingStep();

  }

  public String play(String input) {
    userBlackjack.doStep(input, deck);

    if (isCommand(input)) {
      dealerBlackjack.doStep(deck);
    }

    if (userBlackjack.isWait()) {
      finishDealerStep();
    }

    roundCheck();
    return loggingStep();
  }

  private void roundCheck() {
    if (dealerBlackjack.isWait() && dealerBlackjack.gSt == GameStateBlackJack.OVERFLOW
        && userBlackjack.gSt != GameStateBlackJack.OVERFLOW) {
      userBlackjack.endStep();
    }

    gameState = dealerBlackjack.isWait() && userBlackjack.isWait();
  }

  private String loggingStep() {

    if (userBlackjack.hasAce()) {
      return "Ваши карты:\n" + userBlackjack.showHand() + "Вам выпал " + userBlackjack.getAce()
          .toString() + ". Определите его значение 1/11";
    }

    String stepMessage =
        "Dealer:\n" + dealerBlackjack.showHand() + "Счет Ведущего: " + dealerBlackjack.getCurScore()
            + "\nUser:\n" + userBlackjack.showHand() + "Счет Игрока: "
            + userBlackjack.getCurScore();

    if (!gameState) {
      return stepMessage;
    }

    String mes = stepMessage + ". Cчёт ведущего: " + dealerBlackjack.getCurScore();

    switch (compare(userBlackjack, dealerBlackjack)) {
      case 1:
        if (userBlackjack.getCurScore() != 21) {
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

  private int compare(PlayerBlackJack us, PlayerBlackJack deal) {
    if (us.getGST() != GameStateBlackJack.OVERFLOW) {
      if (us.getCurScore() > deal.getCurScore() || deal.getGST() == GameStateBlackJack.OVERFLOW) {
        return 1;
      }
    }
    if (deal.getCurScore() == us.getCurScore()) {
      return 3;
    }
    return 2;
  }

  private boolean isCommand(String input) {
    return input.contentEquals("/wait") || input.contentEquals("/take") || input.contentEquals(
        "wait") || input.contentEquals("take");
  }

  private void finishDealerStep() {
    while (!dealerBlackjack.isWait()) {
      dealerBlackjack.doStep(deck);
    }
  }

  public void refresh() {
    userBlackjack.refresh();
    dealerBlackjack.refresh();
    deck.refresh();
    gameState = false;
  }
}
