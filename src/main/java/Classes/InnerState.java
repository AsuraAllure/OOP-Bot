package Classes;

import Enums.State;
import Games.BlackJack.BlackJack;
import VK.VK;
import VK.TEST_VK;

public class InnerState {
  private final MessageBox mb;
  private final VK vk;
  private final BlackJack bj;
  private boolean exitState;
  private String userToken;
  private State prevState;

  public InnerState() {
    exitState = false;
    this.mb = new MessageBox();
    this.prevState = State.EMPTY;
    this.vk = new VK();
    this.bj = new BlackJack();
  }

  public InnerState(TEST_OBJECT a) {
    exitState = false;
    this.mb = new MessageBox();
    this.prevState = State.EMPTY;
    this.vk = new TEST_VK();
    this.bj = new BlackJack();
    this.bj.setSeed(a.getSeed());
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
            prevState = State.CHOOSE;
            return mb.getMainMenuMessage();
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
            return mb.getMainMenuMessage();
          case VK:
            prevState = State.WAIT_VK_TOKEN;
            return mb.getVkToken();
          case EXIT:
            exitState = true;
            return mb.getGoodbye();
          case BLACKJACK:
            prevState = State.PLAY_BLACKJACK;
            bj.startPlay();
            return bj.distribution();
          case CHOOSE:
            return mb.getChoiceOfMessenger();
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
          prevState = State.CHOOSE;
          return mb.getMainMenuMessage();
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
            return mb.countChatsMessage() + vk.countUnseenChats() + mb.getVKCommand2();
        }
        return mb.getIncorrectCommand();

      case PLAY_BLACKJACK:
        if (input.contentEquals("/exit")) {
          exitState = true;
          return mb.getGoodbye();
        }
        if (input.contentEquals("/return")) {
          prevState = State.CHOOSE;
          return mb.getMainMenuMessage();
        }


        String stepMessage = "";

        if (!correctBlackJackInput(input))
          return mb.getIncorrectCommand();

        String step = bj.play(input);

        if (bj.getState()) {
          stepMessage += step + "\n" + mb.getEndBlackjack();
          bj.refresh();
          prevState = State.CHOOSE;
        } else {
          stepMessage += step;
        }

        return stepMessage;
    }
    return mb.getIncorrectCommand();
  }
  private boolean correctBlackJackInput(String input){
    return input.contentEquals("1") || input.contentEquals("11") ||
        input.contentEquals("/take") || input.contentEquals("/wait");
  }
  public String sayGoodbye() {
    return mb.getGoodbye();
  }
}
