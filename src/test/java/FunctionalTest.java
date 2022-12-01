import Console.ConsoleBot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionalTest {
    @Test
    public void Test1(){
        TestFactory tf = new TestFactory("src/test/java/Test1");
        ConsoleBot testBot = new ConsoleBot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Привет!
                Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
                                
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                                
                Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.
                                
                Если хочешь еще раз увидеть справку, жми /help.
                Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
                                
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                                
                Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.
                Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.
                Перейди по ссылке **, авторизуйся и введи токен, который там получишь.
                Завершение работы.
                """;
        assertEquals(expectOutput, testOutput);
    }

    @Test
    public void Test2(){
        TestFactory tf = new TestFactory("src/test/java/Test2");
        ConsoleBot testBot = new ConsoleBot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Некорректный запрос. Попробую снова)
                Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
                                
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                                
                Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.
                Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.
                Для подключения к WhatsApp введи свой номер телефона в формате: "9122222222".
                Завершение работы.
                """;
        assertEquals(expectOutput, testOutput);
    }


    @Test
    public void Test3(){
        TestFactory tf = new TestFactory("src/test/java/Test3");
        ConsoleBot testBot = new ConsoleBot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
                                
                В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
                показывать их содержимое и даже отвечать на них (может быть:) ).
                                
                Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.
                Некорректный запрос. Попробую снова)
                Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.
                Для подключения к WhatsApp введи свой номер телефона в формате: "9122222222".
                Завершение работы.
                """;
        assertEquals(expectOutput, testOutput);
    }


    @Test
    public void Test4(){
        TestFactory tf = new TestFactory("src/test/java/Test4");
        ConsoleBot testBot = new ConsoleBot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Некорректный запрос. Попробую снова)
                Завершение работы.
                """;
        assertEquals(expectOutput, testOutput);
    }


    @Test
    public void Test5(){
        TestFactory tf = new TestFactory("src/test/java/Test5");
        ConsoleBot testBot = new ConsoleBot(tf);
        testBot.run();

        String testOutput = tf.getWriter().getTestOut();
        String expectOutput = """
                Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.
                Завершение работы.
                """;
        assertEquals(expectOutput, testOutput);
    }
}
