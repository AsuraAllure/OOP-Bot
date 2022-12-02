package Telegram;

import Classes.InnerState;
import Interfaces.Factory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {

  final private String BOT_TOKEN = System.getenv("BOT_TOKEN");
  final private String BOT_NAME = "CheckVKBot";
  final private InnerState is;

  public TelegramBot(Factory fc) {
    this.is = new InnerState();
  }

  @Override
  public String getBotUsername() {
    return BOT_NAME;
  }

  @Override
  public String getBotToken() {
    return BOT_TOKEN;
  }

  @Override
  public void onUpdateReceived(Update update) {
    try {
      if (update.hasMessage() && update.getMessage().hasText()) {
        Message inMess = update.getMessage();
        String chatId = inMess.getChatId().toString();

        String request = inMess.getText();
        String response = is.execCommand(request);

        SendMessage outMess = new SendMessage();

        outMess.setChatId(chatId);
        outMess.setText(response);

        execute(outMess);
      }
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
}
