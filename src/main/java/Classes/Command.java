package Classes;

import Enums.TypeCommand;

public class Command {
	public TypeCommand t;
	public int hesh;
	Command(String com){
		switch(com) {
			case "exit":
				hesh = 0;
				t = TypeCommand.CORRECT;
				break;
			case "help":
				hesh = 1;
				t = TypeCommand.CORRECT;
				break;
			case "choose":
				hesh = 2;
				t = TypeCommand.CORRECT;
				break;
			default:
				hesh = -1;
				t = TypeCommand.INCORRECT;
		}
	}
	Command(){
		t = TypeCommand.NULLCOMMAND;
		hesh = -1;
	}
	public boolean correct() {
		if (t == TypeCommand.CORRECT)
			return true;
		return false;
	}
	public String toString() {
		if (t == TypeCommand.NULLCOMMAND)
			return "Null";
		if (t == TypeCommand.INCORRECT)
			return "Incorrect";
		switch(hesh){
			case 0:
				return "exit";
			case 1:
				return "help";
			case 2:
				return "choose";
		}
		return "Unknown error";
	}
}
