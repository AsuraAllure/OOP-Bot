package BotPackage;

public class Bot {
    private static Reader rd;
    private static Writer wr;
    private static InnerState is;
    private static Factory fc;
    public static void main(String[] args) {
    	
    	if (args.length == 0)
    		fc = new ConsoleFactory();	
    	
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
    	rd = fc.getReader();
    	wr = fc.getWriter();
    	is = new InnerState(wr,rd);
    }
}