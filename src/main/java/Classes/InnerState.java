package Classes;
public class InnerState {
	private Command com;
	private boolean exitState;
	private final IOManager io;
	private final MessageBox mb;
	private String userData;
	InnerState(IOManager io){
		com = new Command();
		exitState = false;
		this.mb = new MessageBox();
		this.io  = io;
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
				io.writeln(mb.getHelp());
				break;
			case 2:
				io.writeln(mb.getChoiceOfMessenger());
				switch(io.read()) {
					case "1" :
						io.writeln(mb.getWhatsappChoice());
						userData = io.read();
						exitState = true;
						io.writeln(mb.getYourInput() + userData);
						break;
					case "2" :
						io.writeln(mb.getVkChoice());
						userData = io.read();
						exitState = true;
						break;
					default:
						exitState = true;
				}
				break;
			default:
				io.writeln(mb.getWrongCommandMessage());
		}
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
