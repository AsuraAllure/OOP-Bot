package Classes.Commands;

import Enums.TypeCommand.CommandType;

public class ChooseCommand extends Command {

  public ChooseCommand(String com) {
    switch (com) {
      case "/return", "return", "RETURN" -> commandType = CommandType.RETURN;
      case "/vk", "vk" -> commandType = CommandType.VK;
      case "/exit", "exit" -> commandType = CommandType.EXIT;
      case "/blackjack", "blackjack" -> commandType = CommandType.BLACKJACK;
      case "/choose", "choose" -> commandType = CommandType.CHOOSE;
      case "/drunkman", "drunkman" -> commandType = CommandType.DRUNKMAN;
      default -> commandType = CommandType.NOT_CORRECT;
    }
  }
}
