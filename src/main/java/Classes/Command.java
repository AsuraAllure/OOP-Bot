package Classes;

import Enums.CommandType;

public class Command {

  public boolean isCommandCorrect;
  public CommandType commandType;

  Command(String com) {
    switch (com) {
      case "/start":
      case "start":
        commandType = CommandType.START;
        break;
      case "/exit":
      case "exit":
        commandType = CommandType.EXIT;
        break;
      case "/help":
      case "help":
        commandType = CommandType.HELP;
        break;
      case "/choose":
      case "choose":
        commandType = CommandType.CHOOSE;
        break;
      case "/vk":
      case "vk":
        commandType = CommandType.VK;
        break;
      case "/count_unseen_chats":
      case "count_unseen_chats":
        commandType = CommandType.VK_CHOOSE_OPERATION;
        break;
      case "/return":
      case "return":
      case "RETURN":
        commandType = CommandType.RETURN;
        break;
      case "/blackjack":
      case "blackjack":
        commandType = CommandType.BLACKJACK;
        break;
      default:
        commandType = CommandType.NOT_CORRECT;
    }
  }

  public String toString() {
		if (!isCommandCorrect) {
			return "Incorrect";
		}
    switch (commandType) {
      case EXIT:
        return "exit";
      case HELP:
        return "help";
      case CHOOSE:
        return "choose";
      case VK:
        return "vk";
    }
    return "Unknown error";
  }
}
