package BotPackage.Classes;

import BotPackage.Interfaces.Reader;
import BotPackage.Interfaces.Writer;

public class InnerState {
	private Command com;
	private boolean exitState;
	private Writer wr;
	private Reader rd;
	private String UsersData;
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
				break;
			case 1:
				wr.writeln(getHelp());
				wr.setTestOut(getHelp() + "\n");
				rd.incrementCounter();
				break;
			case 2:
				wr.writeln(getChoiceOfMessenger());
				wr.setTestOut(getChoiceOfMessenger() + "\n");
				wr.writeln(getInput());
				wr.setTestOut(getInput() + "\n");
				rd.incrementCounter();
				switch(rd.read()) {
					case "1" :
						wr.writeln(getWhatsappChoice());
						wr.setTestOut(getWhatsappChoice() + "\n");
						wr.writeln(getInput());
						wr.setTestOut(getInput() + "\n");
						rd.incrementCounter();
						UsersData = rd.read();
						wr.writeln(getYourInput() + UsersData);
						wr.setTestOut(getYourInput() + UsersData + "\n");
						exitState = true;
						break;
					case "2" :
						wr.writeln(getVkChoice());
						UsersData = rd.read();
						wr.setTestOut(getVkChoice() + "\n");
						wr.writeln(getInput());
						wr.setTestOut(getInput() + "\n");
						rd.incrementCounter();
						exitState = true;
						break;
					default:
						exitState = true;
						rd.incrementCounter();
				}
				break;
			default:
				wr.writeln(getWrongCommand());
				wr.setTestOut(getWrongCommand() + "\n");
		}
	}

	public String getChoiceOfMessenger() {
		return "Введи \"1\", если хочешь подключиться к WatsApp, \"2\" - к Вконтакте.";
	}

	public String getInput() {
		return "Ввод: ";
	}

	public String getWhatsappChoice() {
		return "Для подключения к WatsApp введите свой номер телефона в формате: \"9122222222\".";
	}

	public String getVkChoice() {
		return "Для подключения к Вконтакте введите логин и пароль (строго в таком порядке) через пробел.";
	}

	public String getYourInput() {
		return "Вы ввели: ";
	}

	public String getWrongCommand(){
		return "Непредвиденная команда";
	}

	public String getHello(){
		return """
				Привет!
				Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				Но пока я могу исполнять только одну команду. Введи choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

				Если хочешь еще раз увидеть справку, введи: "help".""";
	}

	public String getHelp() {
		return """
				Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				Но пока я могу исполнять только одну команду. Введи "choose", чтобы выбрать мессенджер, который тебя сейчас интересует.""";
	}

	public String getIncorrectCommand(){
		return "Некорректный запрос!";
	}

	public String geyGoodbye(){
		return "Завершение работы.";
	}
}
