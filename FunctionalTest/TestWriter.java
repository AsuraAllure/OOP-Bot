package BotPackage.FunctionalTest;
import BotPackage.Interfaces.Writer;

public class TestWriter implements Writer{

    private StringBuilder TestOut;
    public TestWriter() {
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
