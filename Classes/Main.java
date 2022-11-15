package BotPackage.Classes;

import BotPackage.Console.ConsoleFactory;

public class Main {
	public static void main(String[] args) {
		Bot b1 = new Bot(new ConsoleFactory());
		b1.run();
	}
}