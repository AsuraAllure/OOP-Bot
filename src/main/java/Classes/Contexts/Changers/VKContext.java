package Classes.Contexts.Changers;

import Enums.Buttons;
import Enums.State;
import Interfaces.ContextChanger;
import Classes.Contexts.Context;

public class VKContext implements ContextChanger {

  public static void switchContext(Context context){
    context.clearAvailableCommand();
    if (context.getPrevState() == State.CHOOSE) {
      context.clearAvailableCommand();
      context.setPrevState(State.WAIT_VK_TOKEN);
      context.addAvailableCommand(String.valueOf(Buttons.RETURN).toLowerCase());
      context.addAvailableCommand(String.valueOf(Buttons.EXIT).toLowerCase());
      return;
    }
    if (context.getPrevState() == State.WAIT_VK_TOKEN){
      context.clearAvailableCommand();
      context.setPrevState(State.WAIT_VK_COMMAND);
      context.addAvailableCommand(String.valueOf(Buttons.COUNT_UNSEEN_CHAT).toLowerCase());
    }
  }
}
