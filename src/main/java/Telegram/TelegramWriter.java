package Telegram;

import Interfaces.Writer;

public class TelegramWriter implements Writer {
    @Override
    public String writeln(String m) {
        return m;
    }
}
