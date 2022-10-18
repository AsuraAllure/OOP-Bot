package BotPackage.Classes;

import BotPackage.Interfaces.Factory;
import BotPackage.Interfaces.Reader;
import BotPackage.Interfaces.Writer;

public class Bot {
    private Reader rd;
    private Writer wr;
    private InnerState is;
    public Bot(Factory fc){
    	rd = fc.getReader();
    	wr = fc.getWriter();
    	is = new InnerState(wr, rd);
    }
    public void run() {
        wr.writeln(is.getHello());
        wr.setTestOut(is.getHello() + "\n");
        do {
            wr.writeln(is.getInput());
            wr.setTestOut(is.getInput() + "\n");
            is.setCommand(rd.read());
            if (is.correctCommand())
                is.execCommand();
            else {
                wr.writeln(is.getIncorrectCommand());
                wr.setTestOut(is.getIncorrectCommand() + "\n");
                rd.incrementCounter();
            }
        } while (!is.isExit());
        wr.writeln(is.geyGoodbye());
        wr.setTestOut(is.geyGoodbye());
    }

    public void setNameOfFile(String str){
        rd.setNameOfFile(str);
    }

    public String getTestOut(){
        StringBuilder TestOut  = new StringBuilder();
        TestOut.append(wr.getTestOut());
        return TestOut.toString();
    }
}