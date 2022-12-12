package Classes.Strategies;

import Classes.Commands.VKCommand;
import Classes.Contexts.Context;
import Classes.MessageBox;
import Classes.TestObject;
import Enums.Buttons;
import Enums.State;
import Interfaces.Strategy;
import VK.TestVK;
import VK.VK;

public class VKStrategy implements Strategy {

  private final VK vk;
  private final MessageBox mb;

  public VKStrategy() {
    vk = new VK();
    mb = new MessageBox();
  }

  public VKStrategy(TestObject a) {
    vk = new TestVK();
    mb = new MessageBox();
  }

  public String exec(Context context) {
    VKCommand com = new VKCommand(context.getInput());
    switch (com.getComType()) {
      case EXIT:
        context.setExitState(true);
        return mb.getGoodbye();
      case RETURN:
        context.setPrevState(State.CHOOSE);
        context.addAvailableCommand(String.valueOf(Buttons.VK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.DRUNKMAN).toLowerCase());
        return mb.getMainMenuMessage();
      case VK_CHOOSE_OPERATION:
        context.setPrevState(State.EMPTY);
        return mb.countChatsMessage() + vk.countUnseenChats() + mb.getVKCommand2();
      default:
        if (context.getPrevState() == State.WAIT_VK_COMMAND) {
          return mb.getIncorrectCommand();
        }
        if (!vk.setToken(context.getInput())) {
          context.setPrevState(State.WAIT_VK_COMMAND);
          context.addAvailableCommand(String.valueOf(Buttons.COUNT_UNSEEN_CHAT).toLowerCase());
          return mb.getVKCommand();
        }
        return mb.getIncorrectToken();
    }
  }
}
