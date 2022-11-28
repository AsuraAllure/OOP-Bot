package Telegram;

import Interfaces.Factory;
import Interfaces.Reader;
import Interfaces.Writer;

public class TelegramFactory implements Factory {
    @Override
    public Reader getReader() {
        return new TelegramReader();
    }

    @Override
    public Writer getWriter() {
        return new TelegramWriter();
    }
}
