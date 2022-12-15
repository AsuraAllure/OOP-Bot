package Classes.Strategies;

import Classes.Commands.ChooseCommand;
import Classes.Contexts.Changers.BJContext;
import Classes.Contexts.Changers.ChooseContext;
import Classes.Contexts.Changers.VKContext;
import Classes.Contexts.Context;
import Classes.MessageBox;
import Enums.Buttons;
import Enums.State;
import Interfaces.Strategy;

public class ChooseStrategy implements Strategy {

  private final MessageBox mb;

  public ChooseStrategy() {
    mb = new MessageBox();
  }

  public String exec(Context context) {
    ChooseCommand com = new ChooseCommand(context.getInput());

    switch (com.getComType()) {
      case RETURN:
        ChooseContext.switchContext(context);
        return mb.getMainMenuMessage();
      case VK:
        VKContext.switchContext(context);
        return mb.getVkToken();
      case EXIT:
        context.setExitState(true);
        return mb.getGoodbye();
      case BLACKJACK:
        BJContext.switchContext(context);
        return "";
      case DRUNKMAN:
        context.setPrevState(State.PLAY_DRUNKMAN);
        return "";
      case CHOOSE:
        ChooseContext.switchContext(context);
        return mb.getChoiceOfMessenger();
      case NOT_CORRECT:
        context.addAvailableCommand(String.valueOf(Buttons.START).toLowerCase());
        context.setPrevState(State.CHOOSE);
        return mb.getIncorrectCommand();
    }
    context.addAvailableCommand(String.valueOf(Buttons.START).toLowerCase());
    return mb.getIncorrectCommand();
  }
}
