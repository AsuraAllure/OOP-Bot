package BotPackage;

public class ConsoleWriter implements Writer {
	public void sayHello(){
        System.out.println("Привет!\nЯ бот, который облегчит тебе работу с WatsApp и Вконтакте)\nВ" +
                " дальнейшем я смогу уведомлять о сообщениях," +
                " которые пришли тебе в WatsApp и Вконтакте,\nпоказывать их содержимое и даже " +
                "отвечать на них (может быть:) ).\n" +
                "Но пока я могу исполнять только одну команду. Введи choose, чтобы " +
                "выбрать мессенджер, который тебя сейчас интересует.\n\nЕсли" +
                " хочешь еще раз увидеть справку, введи: \"help\".");
	}
	public void myHelp() {
		  System.out.println("Я бот, который облегчит тебе работу с WatsApp и Вконтакте)\n" +
	                "В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,\n" +
	                "показывать их содержимое и даже отвечать на них (может быть:) ).\n" +
	                "Но пока я могу исполнять только одну команду. Введи \"choose\", " +
	                "чтобы выбрать мессенджер, который тебя сейчас интересует.");
	}
	public void writeln(String s) {
		System.out.println(s);
	}
	public void incorrect() {
		System.out.println("Некорректный запрос!");
	}
	public void goodbuy() {
		System.out.println("Завершение работы.");
	}
	public void write(String m) {
		System.out.print(m);
	}
}
