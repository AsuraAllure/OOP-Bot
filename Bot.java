import java.util.Scanner;

public class Bot {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean waitNewInput = true;
        sayHello();
         do {
        String buff1 = scan.nextLine();
        switch (buff1){
            case "help":
                myHelp();
                break;
            case "choose":
                chooseMessenger();
                break;
            case "exit":
                return;
            default:
                System.out.println("Некорректный запрос!");
                break;
        }
        } while(waitNewInput);
    }

    public static void sayHello(){
        System.out.println("Привет!\nЯ бот, который облегчит тебе работу с WatsApp и Вконтакте)\nВ" +
                " дальнейшем я смогу уведомлять о сообщениях," +
                " которые пришли тебе в WatsApp и Вконтакте,\nпоказывать их содержимое и даже " +
                "отвечать на них (может быть:) ).\n" +
                "Но пока я могу исполнять только одну команду. Введи choose, чтобы " +
                "выбрать мессенджер, который тебя сейчас интересует.\n\nЕсли" +
                " хочешь еще раз увидеть справку, введи: \"help\".");
    }

    public static void myHelp(){
        System.out.println("Я бот, который облегчит тебе работу с WatsApp и Вконтакте)\n" +
                "В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,\n" +
                "показывать их содержимое и даже отвечать на них (может быть:) ).\n" +
                "Но пока я могу исполнять только одну команду. Введи \"choose\", " +
                "чтобы выбрать мессенджер, который тебя сейчас интересует.");
    }

    public static void chooseMessenger(){
        System.out.println("Введи \"1\", если хочешь подключиться к WatsApp, \"2\" - к Вконтакте.");

        String buffOp = scan.nextLine();
        switch (buffOp){
            case "1": System.out.println("Для подключения к WatsApp введите свой номер телефона в формате: \"9122222222\".");
                String buffTel = scan.nextLine();
                if (!buffTel.matches("-?\\d+(\\.\\d+)?") || buffTel.length() != 10){
                    System.out.println("Некорректный ввод!");
                } else
                    System.out.println("Запрос обрабатывается...");
                break;
            case "2":System.out.println("Для подключения к Вконтакте введите логин и пароль (строго в таком порядке) через Enter.");
                String buffLog = scan.nextLine();
                String buffPass = scan.nextLine();
                System.out.println("Запрос обрабатывается...");
                break;
        }
    }
}