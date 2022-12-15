package Classes.Commands;

import Enums.TypeCommand.CommandType;

public class VKCommand extends Command {

  public VKCommand(String com) {
    switch (com) {
      case "/exit", "exit" -> commandType = CommandType.EXIT;
      case "/return", "return", "RETURN" -> commandType = CommandType.RETURN;
      case "/count_unseen_chats", "count_unseen_chats" ->
          commandType = CommandType.VK_CHOOSE_OPERATION;
      default -> commandType = CommandType.NOT_CORRECT;
    }
  }
}
