package Classes.Contexts.Changers;

import Classes.Contexts.Context;
import Enums.Buttons;
import Enums.State;
import Interfaces.ContextChanger;

public class DMContext implements ContextChanger {
  public static void switchContext(Context context){
    context.clearAvailableCommand();
    context.addAvailableCommand(String.valueOf(Buttons.PLAY).toLowerCase());
    context.addAvailableCommand(String.valueOf(Buttons.RETURN).toLowerCase());
    context.setPrevState(State.PLAY_DRUNKMAN);
  }
}
