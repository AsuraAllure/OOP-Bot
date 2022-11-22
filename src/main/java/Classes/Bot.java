package Classes;

import Interfaces.Factory;

public class Bot {
    private final IOManager io;
    private final InnerState is;
    public Bot(Factory fc){
        this.io = new IOManager(fc.getReader(), fc.getWriter());
        is = new InnerState(io);
    }
    public void run() {
        io.writeln(is.getHello());
        do {
            is.setCommand(io.read());
            if (is.correctCommand())
                is.execCommand();
            else {
                io.writeln(is.getIncorrectCommand());
            }
        } while (!is.isExit());
        io.write(is.sayGoodbye());
    }
}