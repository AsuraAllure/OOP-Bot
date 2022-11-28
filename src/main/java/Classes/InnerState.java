package Classes;

import Enums.State;

public class InnerState {
	private boolean exitState;
	private final MessageBox mb;
	private String userLogin;
    private String userPassword;
    private String userTelephone;
    private State prevState;
	public InnerState(){
		exitState = false;
		this.mb = new MessageBox();
        this.prevState = State.EMPTY;
	}
	public boolean isExit() {
		return exitState;
	}
	public String execCommand(String str) {
        String input = str;
        Command com;
        switch (prevState){
            case EMPTY:
                com = new Command(input);
                switch (com.commandType){
                    case START:
                        return mb.getStart();
                    case HELP:
                        return mb.getHelp();
                    case CHOOSE:
                        prevState = State.CHOOSE;
                        return mb.getChoiceOfMessenger();
                    case EXIT:
                        return mb.getGoodbye();
                }
                return mb.getIncorrectCommand();
            case CHOOSE:
                com = new Command(input);
                switch (com.commandType){
                    case VK:
                        prevState = State.WAIT_VK_LOGIN;
                        return mb.getVkLogin();
                    case WA:
                        prevState = State.WAIT_WA_TELEPHONE;
                        return mb.getWhatsappChoice();
                }
                return mb.getIncorrectCommand();
            case WAIT_VK_LOGIN:
                userLogin = input;
                prevState = State.WAIT_VK_PASSWORD;
                return mb.getVkPassword();
            case WAIT_VK_PASSWORD:
                userPassword = input;
                //что-то длеаем в вк
                exitState = true;
                return null;
            case WAIT_WA_TELEPHONE:
                userTelephone = input;
                exitState = true;
                //что-то делаем в whatsApp
                return null;
        }
        return getIncorrectCommand();
	}
	public String getIncorrectCommand(){
		return mb.getIncorrectCommand();
	}
	public String sayGoodbye(){
		return mb.getGoodbye();
	}
}
