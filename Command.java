package BotPackage;
class Command {
	typeCommand t;
	int hesh;
	Command(String com){
		switch(com) {
		case "exit":
			hesh = 0;
			t = typeCommand.CORRECT;
			break;
		case "help":
			hesh = 1;
			t = typeCommand.CORRECT;
			break;
		case "choose":
			hesh = 2;
			t = typeCommand.CORRECT;
			break;
		default:
			hesh = -1;
			t = typeCommand.INCORRECT;
		}
	}
	Command(){
		t = typeCommand.NULLCOMMAND;
		hesh = -1;
	}
	boolean correct() {
		if (t == typeCommand.CORRECT)
			return true;
		else
			return false;
	}
	public String toString() {
		if (t == typeCommand.NULLCOMMAND)
			return "Null";
		if (t == typeCommand.INCORRECT)
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
