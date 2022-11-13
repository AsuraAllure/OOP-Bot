package BotPackage.Classes;

import BotPackage.Interfaces.Reader;
import BotPackage.Interfaces.Writer;
public class InnerState {
	private Command com;
	private boolean exitState;
	private final Writer wr;
	private final Reader rd;
	private final MessageBox mb;
	private String userData;
	InnerState(Writer wr, Reader rd){
		com = new Command();
		exitState = false;
		this.mb = new MessageBox();
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
		wr.writeln(com+" ");
	}
	public void execCommand() {
		switch(com.hesh) {
			case 0:
				exitState = true;
				break;
			case 1:
				wr.writeln(mb.getHelp());
				break;
			case 2:
				wr.writeln(mb.getChoiceOfMessenger());
				wr.write(mb.getInputMessage());
				String str = rd.read();
				wr.writeln(str+" ");
				switch(str) {
					case "1" :
						wr.writeln(mb.getWhatsappChoice());
						wr.write(mb.getInputMessage());
						userData = rd.read();
						wr.writeln(userData+" " );
						wr.writeln(mb.getYourInput() + userData );
						exitState = true;
						break;
					case "2" :
						wr.writeln(mb.getVkChoice());
						userData = rd.read();
						wr.write(mb.getInputMessage());
						wr.writeln(userData+" ");
						exitState = true;
						break;
					default:
						exitState = true;
				}
				break;
			default:
				wr.writeln(mb.getWrongCommandMessage());
		}
	}

	public String getInputMessage(){
		return mb.getInputMessage();
	}
	public String getHello(){
		return mb.getHello();
	}
	public String getIncorrectCommand(){
		return mb.getIncorrectCommand();
	}
	public String sayGoodbye(){
		return mb.sayGoodbye();
	}
}
