package BotPackage.FunctionalTest;
import BotPackage.Interfaces.Writer;

public class TestWriter implements Writer{

    private StringBuilder testOut;
    public TestWriter() {
        testOut = new StringBuilder();
    }

    public void writeln(String str) {
        System.out.println(str);
    }

    public String getTestOut() {
        return testOut.toString();
    }

    public void setTestOut(String str) {
        testOut.append(str);
    }
}
