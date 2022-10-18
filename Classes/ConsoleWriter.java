package BotPackage.Classes;

import BotPackage.Interfaces.Writer;

public class ConsoleWriter implements Writer {
	private StringBuilder TestOut;

	public ConsoleWriter() {
		TestOut = new StringBuilder();
	}

	public void writeln(String s) {
		System.out.println(s);
	}

	public String getTestOut() {
		return TestOut.toString();
	}

	public void setTestOut(String testOut) {
		TestOut.append(testOut);
	}
}
