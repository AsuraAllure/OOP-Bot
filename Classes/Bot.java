package BotPackage.Classes;

import BotPackage.Interfaces.Factory;
import BotPackage.Interfaces.Reader;
import BotPackage.Interfaces.Writer;

public class Bot {
    private final Reader rd;
    private final Writer wr;
    private final InnerState is;
    public Bot(Factory fc){
        rd = fc.getReader();
        wr = fc.getWriter();
        is = new InnerState(wr, rd);
    }
    public void run() {
        wr.writeln(is.getHello());
        do {
            wr.write(is.getInputMessage());
            is.setCommand(rd.read());
            if (is.correctCommand())
                is.execCommand();
            else {
                wr.writeln(is.getIncorrectCommand());
            }
        } while (!is.isExit());
        wr.write(is.sayGoodbye());
    }
}