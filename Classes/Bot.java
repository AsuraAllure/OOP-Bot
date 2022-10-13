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
    	is = new InnerState(wr,rd);
    }
    public void run() {
        wr.sayHello();
        do {
            wr.writeln("Ввод команды: ");
            is.setCommand(rd.read());
            if (is.correctCommand())
                is.execCommand();
            else {
                wr.incorrect();
                rd.incrementCounter();
            }
        } while (!is.isExit());
        wr.goodbuy();
    }

    public void setNameOfFile(String str){
        rd.setNameOfFile(str);
    }
    public void getState(boolean[] arrayOfBoolean){
        arrayOfBoolean[0] = is.getHashCommand0();
        arrayOfBoolean[1] = is.getHashCommand1();
        arrayOfBoolean[2] = is.getHashCommand2();
        arrayOfBoolean[3] = is.getHashCommand21();
        arrayOfBoolean[4] = is.getHashCommand22();
    }
}