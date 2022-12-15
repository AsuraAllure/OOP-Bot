package Classes.Strategies;

import Classes.Commands.VKCommand;
import Classes.Contexts.Changers.ChooseContext;
import Classes.Contexts.Changers.ExitContext;
import Classes.Contexts.Changers.StartContext;
import Classes.Contexts.Changers.VKContext;
import Classes.Contexts.Context;
import Classes.MessageBox;
import Classes.TestObject;
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
        ExitContext.switchContext(context);
        return mb.getGoodbye();
      case RETURN:
        ChooseContext.switchContext(context);
        return mb.getMainMenuMessage();
      case VK_CHOOSE_OPERATION:
        StartContext.switchContext(context);
        return mb.countChatsMessage() + vk.countUnseenChats() + mb.getVKCommand2();
      default:

        if (context.getPrevState() == State.WAIT_VK_COMMAND) {
          return mb.getIncorrectCommand();
        }
        if (!vk.setToken(context.getInput())) {
          VKContext.switchContext(context);
          return mb.getVKCommand();
        }
        return mb.getIncorrectToken();
    }
  }
}
