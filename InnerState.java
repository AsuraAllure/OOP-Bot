package BotPackage;
public class InnerState {
	private Command com;
	private boolean exitState;
	private Writer wr;
	private Reader rd;
	private String UsersData1;
	private String UsersData2;
	
	InnerState(Writer wr, Reader rd){
		com = new Command();
		exitState = false;
		this.wr = wr ;
		this.rd = rd;
	}
	boolean isExit() {
		return exitState;
	}
	boolean cor_com() {
		return com.correct();
	}
	void setCommand(String com) {
		this.com = new Command(com);
	}
	void exec_com() {
		switch(com.hesh) {
			case 0:
				exitState = true;
				break;
			case 1:
				wr.myHelp();
				break;
			case 2:
				wr.writeln("Введи \"1\", если хочешь подключиться к WatsApp, \"2\" - к Вконтакте.");
				wr.write("Ввод: ");

				switch(rd.read()) {
					case "1" :
						wr.writeln("Для подключения к WatsApp введите свой номер телефона в формате: \"9122222222\".");
						wr.write("Ввод: ");
						UsersData1 = rd.read();
						wr.write("Вы ввели: ");
						wr.writeln(UsersData1);
						exitState = true;
						break;
					case "2" :
						wr.writeln("Для подключения к Вконтакте введите логин и пароль (строго в таком порядке) через Enter.");
						wr.write("Ввод: ");
						UsersData1 = rd.read();
						wr.writeln(UsersData1);
						wr.write("Вы ввели: ");
						UsersData2 = rd.read();
						wr.write("Вы ввели: ");
						wr.writeln(UsersData2);
						exitState = true;
						break;
					default:
						wr.writeln("Choose problem");
						exitState = true;
				}
				break;
			default:
				wr.writeln("Непредвиденная команда");
		}
	}
}
