package Classes.Strategies;

import Classes.Commands.StandartCommand;
import Classes.Contexts.Changers.ChooseContext;
import Classes.Contexts.Changers.ExitContext;
import Classes.Contexts.Context;
import Classes.MessageBox;
import Classes.TestObject;
import Games.BlackJack.BlackJack;
import Interfaces.Strategy;

public class BJStrategy implements Strategy {
  private final MessageBox mb;
  private final BlackJack bj;
  private boolean dist;

  public BJStrategy() {
    mb = new MessageBox();
    bj = new BlackJack();
    dist = false;
  }

  public BJStrategy(TestObject a) {
    mb = new MessageBox();
    bj = new BlackJack();
    dist = false;
    bj.setSeed(a.getSeed());
  }

  public Boolean getDist(){
    return dist;
  }

  public void setDist(Boolean bool){
    dist = bool;
  }

  public String exec(Context context) {
    StandartCommand com = new StandartCommand(context.getInput());
    switch (com.getComType()) {
      case EXIT:
        ExitContext.switchContext(context);
        return mb.getGoodbye();
      case RETURN:
        ChooseContext.switchContext(context);
        return mb.getMainMenuMessage();
    }
    if (!dist) {
      dist = true;
      bj.startPlay();
      return bj.distribution();
    }
    String stepMessage = "";
    if (!correctBlackJackInput(context.getInput())) {
      return mb.getIncorrectCommand();
    }
    String step = bj.play(context.getInput());

    if (bj.getState()) {
      ChooseContext.switchContext(context);
      stepMessage += step + "\n" + mb.getEndBlackjack();
      bj.refresh();

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
