package Classes.Strategies;

import Classes.Commands.StandartCommand;
import Classes.Contexts.Changers.ChooseContext;
import Classes.Contexts.Changers.DMContext;
import Classes.Contexts.Changers.DMEndContext;
import Classes.Contexts.Context;
import Classes.MessageBox;
import Classes.TestObject;
import Enums.State;
import Games.DrunkMan.DrunkMan;
import Interfaces.Strategy;


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
        ChooseContext.switchContext(context);
        return mb.getMainMenuMessage();
      }
    }
    if (!correctDrunkManInput(context.getInput()))
      return mb.getIncorrectCommand();

    DMContext.switchContext(context);

    String mes = dm.play();

    if (!dm.getState()){
      DMEndContext.switchContext(context);
      dm.refresh();
    }
    return mes;
  }
  private boolean correctDrunkManInput(String input){
    return input.contentEquals("play") || input.contentEquals("/play")
        || input.contentEquals("/drunkman") || input.contentEquals("drunkman") ;
  }
}
