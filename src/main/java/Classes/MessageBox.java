package Classes;
class MessageBox{
    public String getChoiceOfMessenger() {

        return "Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.";
    }
    public String getWhatsappChoice() {
        return "Для подключения к WhatsApp введи свой номер телефона в формате: \"9122222222\".";
    }
    public String getVkToken(){
        return "Перейди по ссылке http://oauth.vk.com/oauth/authorize?redirect_uri=http://oauth.vk.com/blank.html&response_type=token&client_id=51489646&scope=notifications,offline&display=wap, авторизуйся и введи токен, который там получишь.";
    }
    public String getStart(){
        return """
				Привет!
				Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
				
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				
				Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

				Если хочешь еще раз увидеть справку, жми /help.""" ;
    }
    public String getHelp() {
        return """
				Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
				
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				
				Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.""";
    }
    public String getIncorrectCommand(){
        return "Некорректный запрос. Попробую снова)";
    }
    public String getGoodbye(){
        return "Завершение работы.";
    }
}