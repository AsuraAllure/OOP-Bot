package Classes.Contexts.Changers;

import Classes.Contexts.Context;
import Enums.Buttons;
import Enums.State;
import Interfaces.ContextChanger;

public class ChooseContext implements ContextChanger{

  public static void switchContext(Context context){
      context.setPrevState(State.CHOOSE);

      context.clearAvailableCommand();
      context.addAvailableCommand(String.valueOf(Buttons.VK).toLowerCase());
      context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
      context.addAvailableCommand(String.valueOf(Buttons.DRUNKMAN).toLowerCase());
  }
}
