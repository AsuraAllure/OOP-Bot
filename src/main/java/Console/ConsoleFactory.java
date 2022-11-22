package Console;

import Interfaces.Factory;
import Interfaces.Reader;
import Interfaces.Writer;

public class ConsoleFactory implements Factory {
	public Reader getReader() {
		return new ConsoleReader();
	}
	public Writer getWriter() {
		return new ConsoleWriter();
	}
}
