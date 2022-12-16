package Telegram;

import Classes.InnerState;
import Interfaces.Factory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {

  final private String BOT_TOKEN = System.getenv("BOT_TOKEN");
  final private String BOT_NAME = "CheckVKBot";
  private Map<String, InnerState> map;
  final private InnerState is;
  private ReplyKeyboardMarkup replyKeyboardMarkup;

  public TelegramBot(Factory fc) {
    this.is = new InnerState();
    this.map = new HashMap<>();
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

        if (!map.containsKey(chatId)){
          map.put(chatId, new InnerState());
        }
        String response = map.get(chatId).execCommand(request);

        SendMessage outMess = new SendMessage();

        outMess.setChatId(chatId);
        outMess.setText(response);

        initKeyboard(is.getAvailableCommands());
        outMess.setReplyMarkup(replyKeyboardMarkup);

        execute(outMess);
      }
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }
  public void initKeyboard(ArrayList<String> availableCommands)
  {
    replyKeyboardMarkup = new ReplyKeyboardMarkup();
    replyKeyboardMarkup.setResizeKeyboard(true);
    replyKeyboardMarkup.setOneTimeKeyboard(false);

    ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
    KeyboardRow keyboardRow = new KeyboardRow();
    keyboardRows.add(keyboardRow);

    for (String availableCommand : availableCommands) {
      keyboardRow.add(new KeyboardButton(availableCommand));
    }

    replyKeyboardMarkup.setKeyboard(keyboardRows);
  }
}
