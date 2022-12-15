package Classes.Contexts.Changers;

import Classes.Contexts.Context;
import Enums.State;
import Interfaces.ContextChanger;

public class ExitContext implements ContextChanger {
  public static void switchContext(Context context){
    context.setPrevState(State.EMPTY);
    context.clearAvailableCommand();
    context.setExitState(true);
  }
}
