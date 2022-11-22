package Console;

import Interfaces.Writer;

public class ConsoleWriter implements Writer {
	@Override
	public void write(String m){
		System.out.print(m);
	}
	@Override
	public void writeln(String str) {
		System.out.println(str);
	}

}
