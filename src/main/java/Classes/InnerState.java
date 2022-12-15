package Classes;

import Classes.Contexts.Context;
import Classes.Strategies.BJStrategy;
import Classes.Strategies.ChooseStrategy;
import Classes.Strategies.StartStrategy;
import Classes.Strategies.VKStrategy;
import Classes.Strategies.DrunkManStrategy;
import Enums.State;
import Interfaces.Strategy;
import java.util.ArrayList;

public class InnerState {

  private final Context context;
  private Strategy strategy;
  private TestObject to;

  public InnerState() {
    context = new Context();
    strategy = null;
  }

  public InnerState(TestObject a) {
    context = new Context();
    strategy = null;
    to = a;
  }

  public boolean isExit() {
    return context.getExitState();
  }

  public ArrayList<String> getAvailableCommands() {
    return context.getAvailableCommands();
  }

  public String execCommand(String input) {
    context.clearAvailableCommand();

    switch (context.getPrevState()) {
      case EMPTY:
        strategy = new StartStrategy();
        context.setInput(input);
        return strategy.exec(context);
      case CHOOSE:
        strategy = new ChooseStrategy();
        context.setInput(input);
        String mes = strategy.exec(context);
        if (context.getPrevState() == State.PLAY_BLACKJACK) {
          if (to == null) {
            strategy = new BJStrategy();
          } else {
            strategy = new BJStrategy(to);
          }
          mes += strategy.exec(context);
        }
        if (context.getPrevState() == State.PLAY_DRUNKMAN){
          if (to == null){
            strategy = new DrunkManStrategy();
          }else {
            strategy = new DrunkManStrategy(to);
          }
          mes += strategy.exec(context);
        }
        return mes;

      case WAIT_VK_TOKEN:
      case WAIT_VK_COMMAND:
        if (to == null) {
          strategy = new VKStrategy();
        } else {
          strategy = new VKStrategy(to);
        }
        context.setInput(input);
        return strategy.exec(context);

      case PLAY_BLACKJACK:
      case PLAY_DRUNKMAN:
        context.setInput(input);
        return strategy.exec(context);

    }
    MessageBox mb = new MessageBox();
    return mb.getIncorrectCommand();
  }

  public String sayGoodbye() {
    MessageBox mb = new MessageBox();
    return mb.getGoodbye();
  }
}
