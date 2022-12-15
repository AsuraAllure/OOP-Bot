package Classes.Commands;

import Enums.TypeCommand.CommandType;

public class StartCommand extends Command {
  public StartCommand(String input) {
    switch (input) {
      case "/start", "start" -> commandType = CommandType.START;
      case "/help", "help" -> commandType = CommandType.HELP;
      case "/choose", "choose" -> commandType = CommandType.CHOOSE;
      case "/exit", "exit" -> commandType = CommandType.EXIT;
      default -> commandType = CommandType.NOT_CORRECT;
    }
  }
}
