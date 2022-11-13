package BotPackage.FunctionalTest;

import BotPackage.Classes.Bot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalTest {

    @Test
    public void Test1(){
        TestFactory tf = new TestFactory("FunctionalTest/Test1");
        Bot testBot = new Bot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Привет!
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

                Если хочешь еще раз увидеть справку, введи: "help".
                Ввод: help\s
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи "choose", чтобы выбрать мессенджер, который тебя сейчас интересует.
                Ввод: choose\s
                Введи "1", если хочешь подключиться к WatsApp, "2" - к Вконтакте.
                Ввод: 1\s
                Для подключения к WatsApp введите свой номер телефона в формате: "9122222222".
                Ввод: 12345\s
                Вы ввели: 12345
                Завершение работы.""";
        assertEquals(expectOutput, testOutput);
    }

    @Test
    public void Test2(){
        TestFactory tf = new TestFactory("FunctionalTest/Test2");
        Bot testBot = new Bot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Привет!
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

                Если хочешь еще раз увидеть справку, введи: "help".
                Ввод: notCorrectCommand\s
                Некорректный запрос!
                Ввод: help\s
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи "choose", чтобы выбрать мессенджер, который тебя сейчас интересует.
                Ввод: choose\s
                Введи "1", если хочешь подключиться к WatsApp, "2" - к Вконтакте.
                Ввод: 2\s
                Для подключения к Вконтакте введите логин и пароль (строго в таком порядке) через пробел.
                Ввод: login password\s
                Завершение работы.""";
        assertEquals(expectOutput, testOutput);
    }


    @Test
    public void Test3(){
        TestFactory tf = new TestFactory("FunctionalTest/Test3");
        Bot testBot = new Bot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Привет!
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

                Если хочешь еще раз увидеть справку, введи: "help".
                Ввод: help\s
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи "choose", чтобы выбрать мессенджер, который тебя сейчас интересует.
                Ввод: notCorrectCommand\s
                Некорректный запрос!
                Ввод: choose\s
                Введи "1", если хочешь подключиться к WatsApp, "2" - к Вконтакте.
                Ввод: 1\s
                Для подключения к WatsApp введите свой номер телефона в формате: "9122222222".
                Ввод: 89122122222\s
                Вы ввели: 89122122222
                Завершение работы.""";
        assertEquals(expectOutput, testOutput);
    }


    @Test
    public void Test4(){
        TestFactory tf = new TestFactory("FunctionalTest/Test4");
        Bot testBot = new Bot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Привет!
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

                Если хочешь еще раз увидеть справку, введи: "help".
                Ввод: notCorrectCommand\s
                Некорректный запрос!
                Ввод: exit\s
                Завершение работы.""";
        assertEquals(expectOutput, testOutput);
    }


    @Test
    public void Test5(){
        TestFactory tf = new TestFactory("FunctionalTest/Test5");
        Bot testBot = new Bot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Привет!
                Я бот, который облегчит тебе работу с WatsApp и Вконтакте)
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                Но пока я могу исполнять только одну команду. Введи choose, чтобы выбрать мессенджер, который тебя сейчас интересует.

                Если хочешь еще раз увидеть справку, введи: "help".
                Ввод: choose\s
                Введи "1", если хочешь подключиться к WatsApp, "2" - к Вконтакте.
                Ввод: exit\s
                Завершение работы.""";
        assertEquals(expectOutput, testOutput);
    }
}
