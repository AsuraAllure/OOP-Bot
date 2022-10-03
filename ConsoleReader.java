package BotPackage;
import java.util.Scanner;

public class ConsoleReader implements Reader {
	private Scanner scan = new Scanner(System.in);
	public String read() {
		String buf = scan.nextLine();
		return buf;
	}
}
