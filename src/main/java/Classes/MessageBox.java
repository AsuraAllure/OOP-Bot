package Classes;
class MessageBox{
    public String getChoiceOfMessenger() {

        return "Введи \"1\", если хочешь подключиться к WatsApp, \"2\" - к Вконтакте.";
    }

    public String getInputMessage() {
        return "Ввод: ";
    }

    public String getWhatsappChoice() {
        return "Для подключения к WatsApp введите свой номер телефона в формате: \"9122222222\".";
    }

    public String getVkChoice() {
        return "Для подключения к Вконтакте введите логин и пароль (строго в таком порядке) через пробел.";
    }

    public String getYourInput() {
        return "Вы ввели: ";
    }

    public String getWrongCommandMessage(){
        return "Непредвиденная команда";
    }

    public String getHello(){
        return """
				Привет!
				Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				Но пока я могу исполнять только одну команду. Введи choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

				Если хочешь еще раз увидеть справку, введи: "help".""" ;
    }

    public String getHelp() {
        return """
				Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
				В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
				показывать их содержимое и даже отвечать на них (может быть:) ).
				Но пока я могу исполнять только одну команду. Введи "choose", чтобы выбрать мессенджер, который тебя сейчас интересует.""";
    }

    public String getIncorrectCommand(){
        return "Некорректный запрос!";
    }

    public String sayGoodbye(){
        return "Завершение работы.";
    }
}