package BotPackage;
// Идея хэширования имен команд под вопросом
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

}
