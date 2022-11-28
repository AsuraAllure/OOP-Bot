package Console;

import Interfaces.Writer;

public class ConsoleWriter implements Writer {
	@Override
	public String writeln(String str) {
		System.out.println(str);
        return null;
	}
}
