package Classes.Contexts;

import Enums.State;
import java.util.ArrayList;

public class Context {

  private final ArrayList<String> availableCommands;
  private String input;
  private State prevState;
  private boolean exitState;

  public Context() {
    exitState = false;
    prevState = State.EMPTY;
    availableCommands = new ArrayList<>();
  }

  public String getInput() {
    return input;
  }

  public void setInput(String inp) {
    input = inp;
  }

  public boolean getExitState() {
    return exitState;
  }

  public void setExitState(boolean t) {
    exitState = t;
  }

  public ArrayList<String> getAvailableCommands() {
    return availableCommands;
  }

  public void clearAvailableCommand() {
    availableCommands.clear();
  }

  public void addAvailableCommand(String com) {
    availableCommands.add(com);
  }

  public State getPrevState() {
    return prevState;
  }

  public void setPrevState(State st) {
    prevState = st;
  }
}
