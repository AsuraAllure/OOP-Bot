package Classes.Commands;

import Enums.TypeCommand.CommandType;


public class BJCommand extends Command {

  public BJCommand(String com) {
    switch (com) {
      case "/exit", "exit" -> commandType = CommandType.EXIT;
      case "/return", "return", "RETURN" -> commandType = CommandType.RETURN;
      default -> commandType = CommandType.NOT_CORRECT;
    }
  }
}
