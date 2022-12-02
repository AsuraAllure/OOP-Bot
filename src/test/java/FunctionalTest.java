import static org.junit.Assert.assertEquals;

import Console.ConsoleBot;
import org.junit.Test;

public class FunctionalTest {

  @Test
  public void Test1() {
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
        Перейди по ссылке https://oauth.vk.com/authorize?client_id=51489646&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=notifications&response_type=token&v=5.74,  введите токен, который находится в url-адрессе
        На данный момент есть только команда /count_unseen_chats
        Количество чатов с непрочитанными сообщениями: 2
        Нажмите /choose или /help для продолжения
        Завершение работы.
        """;
    assertEquals(expectOutput, testOutput);
  }

  @Test
  public void Test2() {
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
  public void Test3() {
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
  public void Test4() {
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
  public void Test5() {
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

  @Test
  public void Test6() {
    TestFactory tf = new TestFactory("src/test/java/Test6");
    ConsoleBot testBot = new ConsoleBot(tf);
    testBot.run();

    String testOutput = tf.getWriter().getTestOut();
    String expectOutput = """
        Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.
        Перейди по ссылке https://oauth.vk.com/authorize?client_id=51489646&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=notifications&response_type=token&v=5.74,  введите токен, который находится в url-адрессе
        На данный момент есть только команда /count_unseen_chats
        Количество чатов с непрочитанными сообщениями: 2
        Нажмите /choose или /help для продолжения
        Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
                        
        В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
        показывать их содержимое и даже отвечать на них (может быть:) ).
                        
        Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.
        Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.
        Некорректный запрос. Попробую снова)
        Для подключения к WhatsApp введи свой номер телефона в формате: "9122222222".
        Завершение работы.
        """;
    assertEquals(expectOutput, testOutput);
  }

  @Test
  public void Test7() {
    TestFactory tf = new TestFactory("src/test/java/Test7");
    ConsoleBot testBot = new ConsoleBot(tf);
    testBot.run();

    String testOutput = tf.getWriter().getTestOut();
    String expectOutput = """
        Некорректный запрос. Попробую снова)
        Привет!
        Я бот, который облегчит тебе работу с WhatsApp и Вконтакте)
                        
        В дальнейшем я смогу уведомлять о сообщениях, которые пришли тебе в WhatsApp и Вконтакте,
        показывать их содержимое и даже отвечать на них (может быть:) ).
                        
        Но пока я могу исполнять только одну команду. Жми /choose, чтобы выбрать мессенджер, который тебя сейчас интересует.
                        
        Если хочешь еще раз увидеть справку, жми /help.
        Жми /wha, если хочешь подключиться к WhatsApp, /vk - к Вконтакте.
        Перейди по ссылке https://oauth.vk.com/authorize?client_id=51489646&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=notifications&response_type=token&v=5.74,  введите токен, который находится в url-адрессе
        На данный момент есть только команда /count_unseen_chats
        Завершение работы.
        """;
    assertEquals(expectOutput, testOutput);
  }
}
