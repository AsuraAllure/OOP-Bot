package Classes;

class MessageBox {
  public String getMainMenuMessage() {
    return """
        Главное меню.
        Доступные опции:
          Количество сообщений в ВК /vk
          Игра в блэкджек /blackjack
        """;
  }
  public String getHelp() {
    return """
        /exit
          Логический выход из бота.
        /choose
          Переход в главное меню
          /vk
            Переход к командам VK логики. При выполнении дает ссылку, при переходе
            по которой можно будет получить токен для дальнейшей работы с VK
            /count_unseen_chats
              Возвращает количество чатов с непрочитанными сообщениями
          /blackjack
            Начинает игру в blackjack.
        /return
            Возвращает в главное меню.
        """;
  }

  public String getIncorrectCommand() {
    return "Некорректный запрос. Попробую снова)";
  }

  public String getStart() {
    return """
        Привет!
        Для перехода в главное меню /choose.
        Документация команд, /help.""";
  }

  public String getGoodbye() {
    return "Завершение работы.";
  }

  public String getChoiceOfMessenger() {

    return "Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте, /blackjack";
  }
  public String getVkToken() {
    return "Перейди по ссылке"
        + " https://oauth.vk.com/authorize?client_id=51489646&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=notifications&response_type=token&v=5.74, "
        + " введите токен, который находится в url-адрессе";
  }
  public String getIncorrectToken() {
    return "Некорректный ввод токена. Попробуйте снова";
  }
  public String getVKCommand() {
    return "На данный момент есть только команда /count_unseen_chats";
  }

  public String getVKCommand2() {
    return "\nНажмите /choose или /help для продолжения";
  }

  public String countChatsMessage() {
    return "Количество чатов с непрочитанными сообщениями: ";
  }

  public String getEndBlackjack(){
    return "Вы завершили партию. Нажмите /blackjack для продолжения, или /choose для выхода в главное меню";
  }
}