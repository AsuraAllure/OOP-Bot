package Classes;

import Telegram.TelegramBot;
import Telegram.TelegramFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

  public static void main(String[] args) {

    try {
      TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
      telegramBotsApi.registerBot(new TelegramBot(new TelegramFactory()));
    } catch (
        TelegramApiException e) {
      e.printStackTrace();
    }

    /*
    // Вариант метода main(String[] args) для консольной версии бота

        ConsoleBot b1 = new ConsoleBot(new ConsoleFactory());
        b1.run();
*/
  }
}