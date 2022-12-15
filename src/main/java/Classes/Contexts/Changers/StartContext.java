package Classes.Contexts.Changers;

import Classes.Contexts.Context;
import Enums.Buttons;
import Enums.State;
import Interfaces.ContextChanger;


public class StartContext implements ContextChanger {

  public static void switchContext(Context context){
    context.setPrevState(State.EMPTY);

    context.clearAvailableCommand();
    context.addAvailableCommand(String.valueOf(Buttons.CHOOSE).toLowerCase());
    context.addAvailableCommand(String.valueOf(Buttons.HELP).toLowerCase());
  }


}
