package BotPackage;

public class Bot {
    private  Reader rd;
    private  Writer wr;
    private  InnerState is;
    
    Bot(Factory fc){
    	rd = fc.getReader();
    	wr = fc.getWriter();
    	is = new InnerState(wr,rd);
    }
    public void run() {
    	wr.sayHello();
        do {       
        	wr.write("Ввод команды: ");
        	is.setCommand(rd.read());
        	if (is.cor_com())
        		is.exec_com();
        	else
        		wr.incorrect();
         } while(!is.isExit());
        wr.goodbuy();
    }   
    
}