package Classes.Commands;

import Enums.TypeCommand.CommandType;

public class VKCommand extends Command {

  public VKCommand(String com) {
    switch (com) {
      case "/exit":
      case "exit":
        commandType = CommandType.EXIT;
        break;
      case "/return":
      case "return":
      case "RETURN":
        commandType = CommandType.RETURN;
        break;
      case "/count_unseen_chats":
      case "count_unseen_chats":
        commandType = CommandType.VK_CHOOSE_OPERATION;
        break;
      default:
        commandType = CommandType.NOT_CORRECT;
    }
  }
}
