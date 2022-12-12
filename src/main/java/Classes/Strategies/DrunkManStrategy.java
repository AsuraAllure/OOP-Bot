package Classes.Strategies;

import Classes.Commands.StandartCommand;
import Classes.Commands.StartCommand;
import Classes.MessageBox;
import Classes.TestObject;
import Enums.Buttons;
import Enums.State;
import Games.DrunkMan.DrunkMan;
import Interfaces.Strategy;
import Classes.Contexts.Context;


public class DrunkManStrategy implements Strategy {

  private final MessageBox mb;
  private final DrunkMan dm;
  public DrunkManStrategy(TestObject a){
    mb = new MessageBox();
    dm = new DrunkMan();
    dm.setSeed(a.getSeed());
  }
  public DrunkManStrategy(){
    mb = new MessageBox();
    dm = new DrunkMan();
  }
  public String exec(Context context){
    StandartCommand com = new StandartCommand(context.getInput());
    switch (com.getComType()) {
      case EXIT -> {
        context.setExitState(true);
        return mb.getGoodbye();
      }
      case RETURN -> {
        context.setPrevState(State.CHOOSE);
        context.addAvailableCommand(String.valueOf(Buttons.VK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
        context.addAvailableCommand(String.valueOf(Buttons.DRUNKMAN).toLowerCase());
        return mb.getMainMenuMessage();
      }
    }
    if (!correctDrunkManInput(context.getInput()))
      return mb.getIncorrectCommand();

    context.addAvailableCommand(String.valueOf(Buttons.PLAY).toLowerCase());
    context.addAvailableCommand(String.valueOf(Buttons.RETURN).toLowerCase());

    dm.startPlay();
    String mes = dm.play();

    if (dm.getState()){
      context.addAvailableCommand(String.valueOf(Buttons.CHOOSE).toLowerCase());
      context.addAvailableCommand(String.valueOf(Buttons.BLACKJACK).toLowerCase());
      dm.refresh();
      context.setPrevState(State.CHOOSE);
    }
    return mes;
  }
  private boolean correctDrunkManInput(String input){
    return input.contentEquals("play") || input.contentEquals("/play")
        || input.contentEquals("/drunkman") || input.contentEquals("drunkman") ;
  }
}
