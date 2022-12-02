package Classes;

class MessageBox {

  public String getChoiceOfMessenger() {

    return "Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.";
  }

  public String getVKCommand() {
    return "На данный момент есть только команда /count_unseen_chats";
  }

  public String getIncorrectToken() {
    return "Некорректный ввод токена. Попробуйте снова";
  }

  public String getVKCommand2() {
    return "\nНажмите /choose или /help для продолжения";
  }

  public String getWhatsappChoice() {
    return "Для подключения к WhatsApp введи свой номер телефона в формате: \"9122222222\".";
  }

  public String getVkToken() {
    return "Перейди по ссылке" +
        " https://oauth.vk.com/authorize?client_id=51489646&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=notifications&response_type=token&v=5.74, "
        +
        " введите токен, который находится в url-адрессе";
  }

  public String count_chats() {
    return "Количество чатов с непрочитанными сообщениями: ";
  }

  public String getStart() {
    return """
        Привет!
        Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
        				
        В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
        показывать их содержимое и даже отвечать на них (может быть:) ).
        				
        Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

        Если хочешь еще раз увидеть справку, жми /help.""";
  }

  public String getHelp() {
    return """
        Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
        				
        В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
        показывать их содержимое и даже отвечать на них (может быть:) ).
        				
        Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.""";
  }

  public String getIncorrectCommand() {
    return "Некорректный запрос. Попробую снова)";
  }

  public String getGoodbye() {
    return "Завершение работы.";
  }
}