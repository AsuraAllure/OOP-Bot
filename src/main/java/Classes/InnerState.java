package Classes;

import Enums.State;

public class InnerState {
	private boolean exitState;
	private final MessageBox mb;
	private String userToken;
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
                        exitState = true;
                        return mb.getGoodbye();
                    case NOT_CORRECT:
                        prevState = State.EMPTY;
                        return mb.getIncorrectCommand();
                }
                return mb.getIncorrectCommand();
            case CHOOSE:
                com = new Command(input);
                switch (com.commandType){
                    case VK:
                        prevState = State.WAIT_VK_TOKEN;
                        return mb.getVkToken();
                    case WA:
                        prevState = State.WAIT_WA_TELEPHONE;
                        return mb.getWhatsappChoice();
                    case EXIT:
                        exitState = true;
                        return mb.getGoodbye();
                    case NOT_CORRECT:
                        prevState = State.CHOOSE;
                        return mb.getIncorrectCommand();
                }
                return mb.getIncorrectCommand();
            case WAIT_VK_TOKEN:
                userToken = input;
                // что-то делаем в вк
                exitState = true;
                return mb.getGoodbye();
            case WAIT_WA_TELEPHONE:
                userTelephone = input;
                exitState = true;
                //что-то делаем в whatsApp
                return mb.getGoodbye();
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
