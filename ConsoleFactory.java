package BotPackage;

public class ConsoleFactory implements Factory {
	public Reader getReader() {
		return new ConsoleReader();
	}
	public Writer getWriter() {
		return new ConsoleWriter();
	}
}
