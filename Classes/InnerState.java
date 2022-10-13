package BotPackage.Classes;

import BotPackage.Interfaces.Reader;
import BotPackage.Interfaces.Writer;

public class InnerState {
	private Command com;
	private boolean exitState;
	private Writer wr;
	private Reader rd;
	private String UsersData;
	private boolean hashCommand0;
	private boolean hashCommand1;
	private boolean hashCommand2;
	private boolean hashCommand21;
	private boolean hashCommand22;

	public InnerState(){
		hashCommand0 = false;
		hashCommand1 = false;
		hashCommand2 = false;
		hashCommand21 = false;
		hashCommand22 = false;
	}
	
	InnerState(Writer wr, Reader rd){
		com = new Command();
		exitState = false;
		this.wr = wr ;
		this.rd = rd;
	}
	public boolean isExit() {
		return exitState;
	}
	public boolean correctCommand() {
		return com.correct();
	}
	public void setCommand(String com) {
		this.com = new Command(com);
	}
	public void execCommand() {
		switch(com.hesh) {
			case 0:
				exitState = true;
				setHashCommand0(true);
				break;
			case 1:
				wr.myHelp();
				rd.incrementCounter();
				setHashCommand1(true);
				break;
			case 2:
				wr.writeln("Введи \"1\", если хочешь подключиться к WatsApp, \"2\" - к Вконтакте.");
				wr.writeln("Ввод: ");
				rd.incrementCounter();
				setHashCommand2(true);
				switch(rd.read()) {
					case "1" :
						wr.writeln("Для подключения к WatsApp введите свой номер телефона в формате: \"9122222222\".");
						wr.writeln("Ввод: ");
						rd.incrementCounter();
						UsersData = rd.read();
						wr.writeln("Вы ввели: " + UsersData);
						exitState = true;
						setHashCommand21(true);
						break;
					case "2" :
						wr.writeln("Для подключения к Вконтакте введите логин и пароль (строго в таком порядке) через пробел.");
						wr.writeln("Ввод: ");
						rd.incrementCounter();
						UsersData = rd.read();
						exitState = true;
						setHashCommand22(true);
						break;
					default:
						exitState = true;
						rd.incrementCounter();
						setHashCommand0(true);
				}
				break;
			default:
				wr.writeln("Непредвиденная команда");
		}
	}

	public boolean getHashCommand0() {
		return hashCommand0;
	}

	public void setHashCommand0(boolean b){
		hashCommand0 = b;
	}

	public boolean getHashCommand1() {
		return hashCommand1;
	}

	public void setHashCommand1(boolean b){
		hashCommand1 = b;
	}

	public boolean getHashCommand2() {
		return hashCommand2;
	}

	public void setHashCommand2(boolean b){
		hashCommand2 = b;
	}

	public boolean getHashCommand21() {
		return hashCommand21;
	}
	public void setHashCommand21(boolean b){
		hashCommand21 = b;
	}

	public boolean getHashCommand22() {
		return hashCommand22;
	}

	public void setHashCommand22(boolean b){
		hashCommand22 = b;
	}
}
