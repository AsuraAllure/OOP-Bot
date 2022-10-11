package BotPackage;

public class Main {

	public static void main(String[] args) {
		Bot b1 = new Bot(new ConsoleFactory());
		b1.run();
		
		Tester t1 = new Tester();
		t1.testCommand();
		t1.testConsoleFactory();
	}
}
