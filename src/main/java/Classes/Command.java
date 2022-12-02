package Classes;

import Enums.CommandType;

public class Command {

  public boolean isCommandCorrect;
  public CommandType commandType;

  Command(String com) {
    switch (com) {
      case "/start":
        commandType = CommandType.START;
        break;
      case "/exit":
        commandType = CommandType.EXIT;
        break;
      case "/help":
        commandType = CommandType.HELP;
        break;
      case "/choose":
        commandType = CommandType.CHOOSE;
        break;
      case "/vk":
        commandType = CommandType.VK;
        break;
      case "/wha":
        commandType = CommandType.WA;
        break;
      case "/count_unseen_chats":
        commandType = CommandType.VK_CHOOSE_OPERATION;
        break;
      case "/return":
        commandType = CommandType.RETURN;
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
      case WA:
        return "wha";
    }
    return "Unknown error";
  }
}
