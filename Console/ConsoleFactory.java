package BotPackage.Console;

import BotPackage.Interfaces.Factory;
import BotPackage.Interfaces.Reader;
import BotPackage.Interfaces.Writer;

public class ConsoleFactory implements Factory {
	public Reader getReader() {
		return new ConsoleReader();
	}
	public Writer getWriter() {
		return new ConsoleWriter();
	}
}
