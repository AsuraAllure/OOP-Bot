package Classes.Strategies;

import Classes.Commands.StandartCommand;
import Classes.Contexts.Context;
import Classes.MessageBox;
import Classes.TestObject;
import Enums.Buttons;
import Enums.State;
import Games.BlackJack.BlackJack;
import Interfaces.Strategy;

public class BJStrategy implements Strategy {

  private final MessageBox mb;
  private final BlackJack bj;
  private boolean distr;

  public BJStrategy() {
    mb = new MessageBox();
    bj = new BlackJack();
    distr = false;
  }

  public BJStrategy(TestObject a) {
    mb = new MessageBox();
    bj = new BlackJack();
    distr = false;
    bj.setSeed(a.getSeed());
  }

  public String exec(Context context) {
    StandartCommand com = new StandartCommand(context.getInput());
    switch (com.getComType()) {
      case EXIT:
        context.setExitState(true);
        return mb.getGoodbye();
      case RETURN:
        context.setPrevState(State.CHOOSE);
        context.addAvailableCommand(String.valueOf(Buttons.VK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.DRUNKMAN).toLowerCase());
        return mb.getMainMenuMessage();
    }
    if (!distr) {
      distr = true;
      bj.startPlay();
      return bj.distribution();
    }
    String stepMessage = "";
    if (!correctBlackJackInput(context.getInput())) {
      return mb.getIncorrectCommand();
    }
    String step = bj.play(context.getInput());

    if (bj.getState()) {
      context.addAvailableCommand(String.valueOf(Buttons.CHOOSE).toLowerCase());
      context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
      stepMessage += step + "\n" + mb.getEndBlackjack();
      bj.refresh();
      context.setPrevState(State.CHOOSE);
    } else {
      stepMessage += step;
    }
    return stepMessage;
  }

  private boolean correctBlackJackInput(String input) {
    return input.contentEquals("1") || input.contentEquals("11") || input.contentEquals("/take")
        || input.contentEquals("/wait") || input.contentEquals("take") || input.contentEquals(
        "wait");
  }
}
