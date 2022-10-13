package BotPackage.Classes;

//import BotPackage.Classes.Command;
//import BotPackage.Classes.ConsoleFactory;
import BotPackage.Interfaces.Factory;

public class Tester {
	public void testCommand() {
		System.out.print("Ничего не ввели, Ожидается Null\nCостояник команды: ");
		Command c1 = new Command();
		System.out.println(c1.toString());
		
		System.out.print("Ввели exit, Ожидается exit\nCостояник команды: ");
		c1 = new Command("exit");
		System.out.println(c1.toString());
		
		System.out.print("Ввели help, Ожидается help\nCостояник команды: ");
		c1 = new Command("help");
		System.out.println(c1.toString());
		
		System.out.print("Ввели choose, Ожидается choose\nCостояник команды: ");
		c1 = new Command("choose");
		System.out.println(c1.toString());
		
		System.out.print("Ввели некоректное значение, Ожидается Incorrect\nCостояник команды: ");
		c1 = new Command("asdfsa");
		System.out.println(c1.toString());
	}

	public void testConsoleFactory() {
		Factory f = new ConsoleFactory();
		System.out.print("Выполняется функция getReader(). Ожидается получить ConsoleReader\nПолучили:");
		System.out.println(f.getReader().getClass().toString());
		System.out.print("Выполняется функция getWriter(). Ожидается получить ConsoleWriter\nПолучили:");
		System.out.println(f.getWriter().getClass().toString());
	}

	
}
