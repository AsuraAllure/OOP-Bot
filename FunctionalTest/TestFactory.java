package BotPackage.FunctionalTest;

import BotPackage.Interfaces.Factory;
import BotPackage.Interfaces.Reader;
public class TestFactory implements Factory {

    private final TestReader tr;
    private final TestWriter tw;
    public TestFactory(String nameTestFile){
        this.tr = new TestReader(nameTestFile);
        this.tw = new TestWriter();
    }
    @Override
    public Reader getReader() {
        return this.tr;
    }
    @Override
    public TestWriter getWriter() {
        return this.tw;
    }
}
