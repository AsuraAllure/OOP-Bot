package Classes;
class MessageBox{
    public String getChoiceOfMessenger() {

        return "Жми /wa, если хочешь подключиться к WatsApp, /vk - к Вконтакте.";
    }
    public String getInputMessage() {
        return "Ввод: ";
    }

    public String getWhatsappChoice() {
        return "Для подключения к WhatsApp введи свой номер телефона в формате: \"9122222222\".";
    }
    public String getVkLogin() {
        return "Введите логин:";
    }
    public String getVkPassword(){
        return "Введите пароль:";
    }
    public String getYourInput() {
        return "Вы ввели: ";
    }
    public String getWrongCommandMessage(){
        return "Непредвиденная команда";
    }
    public String getStart(){
        return """
				Привет!
				Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
				
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				
				Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

				Если хочешь еще раз увидеть справку, жми /help.""" ;
    }
    public String getHelp() {
        return """
				Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
				
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				
				Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.""";
    }
    public String getIncorrectCommand(){
        return "Некорректный запрос!";
    }
    public String getGoodbye(){
        return "Завершение работы.";
    }
}