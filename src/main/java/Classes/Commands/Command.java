package Classes.Commands;

import Enums.TypeCommand.CommandType;

public class Command {
  protected CommandType commandType;
  Command() {
    commandType = CommandType.NOT_CORRECT;
  }
  public CommandType getComType() {
    return commandType;
  }
}
