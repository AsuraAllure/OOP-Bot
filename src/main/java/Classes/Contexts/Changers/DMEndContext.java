package Classes.Contexts.Changers;

import Classes.Contexts.Context;
import Enums.Buttons;
import Enums.State;
import Interfaces.ContextChanger;

public class DMEndContext implements ContextChanger {
  public static void switchContext(Context context){
    context.clearAvailableCommand();
    context.addAvailableCommand(String.valueOf(Buttons.CHOOSE).toLowerCase());
    context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
    context.setPrevState(State.CHOOSE);
  }
}