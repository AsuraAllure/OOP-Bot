package Classes.Strategies;

import Classes.Commands.StartCommand;
import Classes.Contexts.Changers.ChooseContext;
import Classes.Contexts.Context;
import Classes.Contexts.Changers.ExitContext;
import Classes.Contexts.Changers.HelpContext;
import Classes.Contexts.Changers.StartContext;
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
        StartContext.switchContext(context);
        return mb.getStart();
      case HELP:
        HelpContext.switchContext(context);
        return mb.getHelp();
      case CHOOSE:
        ChooseContext.switchContext(context);
        return mb.getChoiceOfMessenger();
      case EXIT:
        ExitContext.switchContext(context);
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
