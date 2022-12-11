package Classes.Commands;

import Enums.TypeCommand.CommandType;

public class StartCommand extends Command {

  public StartCommand(String input) {
    switch (input) {
      case "/start":
      case "start":
        commandType = CommandType.START;
        break;
      case "/help":
      case "help":
        commandType = CommandType.HELP;
        break;
      case "/choose":
      case "choose":
        commandType = CommandType.CHOOSE;
        break;
      case "/exit":
      case "exit":
        commandType = CommandType.EXIT;
        break;
      default:
        commandType = CommandType.NOT_CORRECT;
    }
  }
}
