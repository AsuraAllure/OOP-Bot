package BotPackage;

public class Bot {
    private static Reader rd;
    private static Writer wr;
    private static InnerState is;
    public static void main(String[] args) {
    	
    	_init();
    
    	wr.sayHello();
        do {       
        	wr.write("Ввод команды: ");
        	is.setCommand(rd.read());
        	if (is.cor_com()) // переделать в correct_command
        		is.exec_com();
        	else
        		wr.incorrect();
         } while(!is.isExit());
        wr.goodbuy();
    }   
    
    private static void _init() {
    	rd = new ConsoleReader();
    	wr = new ConsoleWriter();
    	is = new InnerState(wr,rd);
    }
}