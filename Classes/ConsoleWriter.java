package BotPackage.Classes;

import BotPackage.Interfaces.Writer;

public class ConsoleWriter implements Writer {
	private StringBuilder testOut;

	public ConsoleWriter() {
		testOut = new StringBuilder();
	}

	public void writeln(String s) {
		System.out.println(s);
	}

	public String getTestOut() {
		return testOut.toString();
	}

	public void setTestOut(String str) {
		testOut.append(str);
	}
}
