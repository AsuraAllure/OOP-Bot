package Classes.Strategies;

import Classes.Commands.ChooseCommand;
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
        context.addAvailableCommand(String.valueOf(Buttons.VK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
        return mb.getMainMenuMessage();
      case VK:
        context.setPrevState(State.WAIT_VK_TOKEN);
        context.addAvailableCommand(String.valueOf(Buttons.RETURN).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.EXIT).toLowerCase());
        return mb.getVkToken();
      case EXIT:
        context.setExitState(true);
        return mb.getGoodbye();
      case BLACKJACK:
        context.addAvailableCommand(String.valueOf(Buttons.WAIT).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.TAKE).toLowerCase());
        context.setPrevState(State.PLAY_BLACKJACK);
        return "";
      case CHOOSE:
        context.addAvailableCommand(String.valueOf(Buttons.VK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
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
