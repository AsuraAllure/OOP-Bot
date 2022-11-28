package Classes;

import Enums.CommandType;

public class Command {
	public boolean isCommandCorrect;
	public CommandType commandType;
	Command(String com){
		switch(com) {
            case "/start":
                commandType = CommandType.START;
                isCommandCorrect = true;
                break;
			case "/exit":
                commandType = CommandType.EXIT;
                isCommandCorrect = true;
				break;
			case "/help":
                commandType = CommandType.HELP;
                isCommandCorrect = true;
				break;
			case "/choose":
                commandType = CommandType.CHOOSE;
                isCommandCorrect = true;
				break;
            case "/vk":
                commandType = CommandType.VK;
                isCommandCorrect = true;
                break;
            case "/wa":
                commandType = CommandType.WA;
                isCommandCorrect = true;
                break;
			default:
                isCommandCorrect = false;
		}
	}
	public String toString() {
		if (!isCommandCorrect)
			return "Incorrect";
		switch(commandType){
			case EXIT:
				return "exit";
			case HELP:
				return "help";
			case CHOOSE:
				return "choose";
            case VK:
                return "vk";
            case WA:
                return "wa";
		}
		return "Unknown error";
	}
}
