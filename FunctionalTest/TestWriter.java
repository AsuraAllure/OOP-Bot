package BotPackage.FunctionalTest;
import BotPackage.Interfaces.Writer;

public class TestWriter implements Writer{

    private StringBuilder testOut;
    public TestWriter() {
        testOut = new StringBuilder();
    }
    public void writeln(String str) {
        testOut.append(str+'\n');
    }
    public void write(String str){

        testOut.append(str);
    }
    public String getTestOut()
    {
        return testOut.toString();
    }

}
