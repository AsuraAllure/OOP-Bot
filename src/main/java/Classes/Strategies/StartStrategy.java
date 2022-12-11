package Classes.Strategies;

import Classes.Commands.StartCommand;
import Classes.Contexts.Context;
import Classes.MessageBox;
import Enums.Buttons;
import Enums.State;
import Interfaces.Strategy;

public class StartStrategy implements Strategy {

  private final MessageBox mb;

  public StartStrategy() {
    mb = new MessageBox();
  }

  public String exec(Context context) {
    StartCommand com = new StartCommand(context.getInput());
    switch (com.getComType()) {
      case START:
        context.addAvailableCommand(String.valueOf(Buttons.CHOOSE).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.HELP).toLowerCase());
        return mb.getStart();
      case HELP:
        context.addAvailableCommand(String.valueOf(Buttons.EXIT).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.CHOOSE).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.RETURN).toLowerCase());
        return mb.getHelp();
      case CHOOSE:
        context.setPrevState(State.CHOOSE);
        context.addAvailableCommand(String.valueOf(Buttons.VK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
        return mb.getChoiceOfMessenger();
      case EXIT:
        context.setExitState(true);
        return mb.getGoodbye();
      case NOT_CORRECT:
        context.setPrevState(State.EMPTY);
        context.addAvailableCommand(String.valueOf(Buttons.START).toLowerCase());
        return mb.getIncorrectCommand();
    }
    context.addAvailableCommand(String.valueOf(Buttons.START).toLowerCase());
    return mb.getIncorrectCommand();
  }
}
