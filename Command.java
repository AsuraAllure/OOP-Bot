package BotPackage;
class Command {
	type_Command t;
	int hesh;
	Command(String com){
		switch(com) {
		case "exit":
			hesh = 0;
			t = type_Command.correct;
			break;
		case "help":
			hesh = 1;
			t = type_Command.correct;
			break;
		case "choose":
			hesh = 2;
			t = type_Command.correct;
			break;
		default:
			hesh = -1;
			t = type_Command.incorrect;
		}
	}
	Command(){
		t = type_Command.nullcommand;
		hesh = -1;
	}
	boolean correct() {
		if (t == type_Command.correct)
			return true;
		else
			return false;
	}
	public String toString() {
		if (t == type_Command.nullcommand)
			return "Null";
		if (t == type_Command.incorrect)
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
