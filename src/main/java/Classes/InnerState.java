package Classes;

import Enums.State;
import Enums.Buttons;
import Games.BlackJack.BlackJack;
import VK.TestVK;
import VK.VK;
import java.util.ArrayList;

public class InnerState {
  private final MessageBox mb;
  private final VK vk;
  private final BlackJack bj;
  private boolean exitState;
  private String userToken;
  private State prevState;
  private ArrayList<String> availableCommands;

  public InnerState() {
    exitState = false;
    this.mb = new MessageBox();
    this.prevState = State.EMPTY;
    this.vk = new VK();
    this.bj = new BlackJack();
    this.availableCommands = new ArrayList<>();
  }

  public InnerState(TestObject a) {
    exitState = false;
    this.mb = new MessageBox();
    this.prevState = State.EMPTY;
    this.vk = new TestVK();
    this.bj = new BlackJack();
    this.bj.setSeed(a.getSeed());
    this.availableCommands = new ArrayList<>();
  }

  public boolean isExit() {
    return exitState;
  }
  public ArrayList<String> getAvailableCommands(){
    return availableCommands;
  }

  public String execCommand(String str) {
    String input = str;
    Command com;
    availableCommands.clear();
    switch (prevState) {
      case EMPTY:
        com = new Command(input);
        switch (com.commandType) {
          case START:
            availableCommands.add(String.valueOf(Buttons.CHOOSE).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.HELP).toLowerCase());
            return mb.getStart();
          case HELP:
            availableCommands.add(String.valueOf(Buttons.EXIT).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.CHOOSE).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.RETURN).toLowerCase());
            return mb.getHelp();
          case CHOOSE:
            prevState = State.CHOOSE;
            availableCommands.add(String.valueOf(Buttons.VK).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.BLACKJACK).toLowerCase());
            return mb.getChoiceOfMessenger();
          case EXIT:
            exitState = true;
            return mb.getGoodbye();
          case NOT_CORRECT:
            prevState = State.EMPTY;
            availableCommands.add(String.valueOf(Buttons.START).toLowerCase());
            return mb.getIncorrectCommand();
        }
        availableCommands.add(String.valueOf(Buttons.START).toLowerCase());
        return mb.getIncorrectCommand();
      case CHOOSE:
        com = new Command(input);
        switch (com.commandType) {
          case RETURN:
            availableCommands.add(String.valueOf(Buttons.VK).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.BLACKJACK).toLowerCase());
            return mb.getMainMenuMessage();
          case VK:
            prevState = State.WAIT_VK_TOKEN;
            availableCommands.add(String.valueOf(Buttons.RETURN).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.EXIT).toLowerCase());
            return mb.getVkToken();
          case EXIT:
            exitState = true;
            return mb.getGoodbye();
          case BLACKJACK:
            availableCommands.add(String.valueOf(Buttons.WAIT).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.TAKE).toLowerCase());
            prevState = State.PLAY_BLACKJACK;
            bj.startPlay();
            return bj.distribution();
          case CHOOSE:
            availableCommands.add(String.valueOf(Buttons.VK).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.BLACKJACK).toLowerCase());
            return mb.getChoiceOfMessenger();
          case NOT_CORRECT:
            availableCommands.add(String.valueOf(Buttons.START).toLowerCase());
            prevState = State.CHOOSE;
            return mb.getIncorrectCommand();
        }
        availableCommands.add(String.valueOf(Buttons.START).toLowerCase());
        return mb.getIncorrectCommand();
      case WAIT_VK_TOKEN:
        userToken = input;
        if (input.contentEquals("/exit") || input.contentEquals("exit")) {
          exitState = true;
          return mb.getGoodbye();
        }
        if (input.contentEquals("/return") || input.contentEquals("RETURN")) {
          prevState = State.CHOOSE;
          availableCommands.add(String.valueOf(Buttons.VK).toLowerCase());
          availableCommands.add(String.valueOf(Buttons.BLACKJACK).toLowerCase());
          return mb.getMainMenuMessage();
        }
        if (!vk.setToken(userToken)) {
          prevState = State.WAIT_VK_COMMAND;
          availableCommands.add(String.valueOf(Buttons.COUNT_UNSEEN_CHAT).toLowerCase());
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
            availableCommands.add(String.valueOf(Buttons.CHOOSE).toLowerCase());
            availableCommands.add(String.valueOf(Buttons.HELP).toLowerCase());
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
          availableCommands.add(String.valueOf(Buttons.VK).toLowerCase());
          availableCommands.add(String.valueOf(Buttons.BLACKJACK).toLowerCase());
          return mb.getMainMenuMessage();
        }
        String stepMessage = "";

        if (!correctBlackJackInput(input))
          return mb.getIncorrectCommand();

        String step = bj.play(input);

        if (bj.getState()) {
          availableCommands.add(String.valueOf(Buttons.CHOOSE).toLowerCase());
          availableCommands.add(String.valueOf(Buttons.BLACKJACK).toLowerCase());
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
        input.contentEquals("/take") || input.contentEquals("/wait")
        || input.contentEquals("take") || input.contentEquals("wait");
  }
  public String sayGoodbye() {
    return mb.getGoodbye();
  }
}
