package Classes;

import Console.*;

public class Main {

  public static void main(String[] args) {
    /*
    try {
      TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
      telegramBotsApi.registerBot(new TelegramBot(new TelegramFactory()));
    } catch (
        TelegramApiException e) {
      e.printStackTrace();
    }
    */
    // Вариант метода main(String[] args) для консольной версии бота
        ConsoleBot b1 = new ConsoleBot(new ConsoleFactory());
        b1.run();

  }
}