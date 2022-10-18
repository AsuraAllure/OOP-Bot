package BotPackage.FunctionalTest;

import BotPackage.Interfaces.Factory;
import BotPackage.Interfaces.Reader;
import BotPackage.Interfaces.Writer;

public class TestFactory implements Factory {
    @Override
    public Reader getReader() {
        return new TestReader();
    }
    @Override
    public Writer getWriter() {
        return new TestWriter();
    }
}
