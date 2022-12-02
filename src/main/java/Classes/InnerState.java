package Classes;

import Console.ConsoleBot;
import VK.VK;
import VK.TEST_VK;
import Enums.State;

public class InnerState {

  private boolean exitState;
  private final MessageBox mb;
  private String userToken;
  private String userTelephone;
  private VK vk;
  private State prevState;

  public InnerState() {
    exitState = false;
    this.mb = new MessageBox();
    this.prevState = State.EMPTY;
    this.vk = new VK();
  }

  public InnerState(ConsoleBot a) {
    exitState = false;
    this.mb = new MessageBox();
    this.prevState = State.EMPTY;
    this.vk = new TEST_VK();
  }

  public boolean isExit() {
    return exitState;
  }

  public String execCommand(String str) {
    String input = str;
    Command com;
    switch (prevState) {
      case EMPTY:
        com = new Command(input);
        switch (com.commandType) {
          case RETURN:
            prevState = State.EMPTY;
            return mb.getStart();
          case START:
            return mb.getStart();
          case HELP:
            return mb.getHelp();
          case CHOOSE:
            prevState = State.CHOOSE;
            return mb.getChoiceOfMessenger();
          case EXIT:
            exitState = true;
            return mb.getGoodbye();
          case NOT_CORRECT:
            prevState = State.EMPTY;
            return mb.getIncorrectCommand();
        }
        return mb.getIncorrectCommand();
      case CHOOSE:
        com = new Command(input);
        switch (com.commandType) {

          case RETURN:
            prevState = State.EMPTY;
            return mb.getStart();
          case VK:
            prevState = State.WAIT_VK_TOKEN;
            return mb.getVkToken();
          case WA:
            prevState = State.WAIT_WA_TELEPHONE;
            return mb.getWhatsappChoice();
          case EXIT:
            exitState = true;
            return mb.getGoodbye();
          case NOT_CORRECT:
            prevState = State.CHOOSE;
            return mb.getIncorrectCommand();
        }
        return mb.getIncorrectCommand();
      case WAIT_VK_TOKEN:
        userToken = input;
        if (input.contentEquals("/exit")) {
          exitState = true;
          return mb.getGoodbye();
        }
        if (input.contentEquals("/return")) {
          prevState = State.EMPTY;
          return mb.getStart();
        }
        if (!vk.setToken(userToken)) {
          prevState = State.WAIT_VK_COMMAND;
          return mb.getVKCommand();
        }
        return mb.getIncorrectToken();
      case WAIT_VK_COMMAND:
        com = new Command(input);
        switch (com.commandType) {
          case EXIT:
            exitState = true;
            return mb.getGoodbye();
          case RETURN:
            prevState = State.EMPTY;
            return mb.getStart();
          case VK_CHOOSE_OPERATION:
            prevState = State.EMPTY;
            return mb.count_chats() + vk.countUnseenChats() + mb.getVKCommand2();
        }
        return mb.getIncorrectCommand();
      case WAIT_WA_TELEPHONE:
        userTelephone = input;
        exitState = true;
        //что-то делаем в whatsApp
        return mb.getGoodbye();
    }
    return getIncorrectCommand();
  }

  public String getIncorrectCommand() {
    return mb.getIncorrectCommand();
  }

  public String sayGoodbye() {
    return mb.getGoodbye();
  }
}
