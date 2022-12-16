package Classes.Contexts.Changers;

import Classes.Contexts.Context;
import Enums.Buttons;
import Enums.State;
import Interfaces.ContextChanger;

public class BJContext implements ContextChanger {
  public static void switchContext(Context context){
    context.clearAvailableCommand();
    context.addAvailableCommand(String.valueOf(Buttons.WAIT).toLowerCase());
    context.addAvailableCommand(String.valueOf(Buttons.TAKE).toLowerCase());
    context.setPrevState(State.PLAY_BLACKJACK);
  }
}
