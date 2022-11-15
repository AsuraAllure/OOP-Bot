package BotPackage.Console;
import BotPackage.Interfaces.Reader;
import java.util.Scanner;
public class ConsoleReader implements Reader {
	private Scanner scan = new Scanner(System.in);
	public String read() {
		return	scan.nextLine();

	}

}
