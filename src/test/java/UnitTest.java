//import org.junit.Test;

import static org.junit.Assert.assertEquals;

import CardGame.GameException;
import Classes.Contexts.Context;
import Classes.Strategies.ChooseStrategy;
import Classes.Strategies.StartStrategy;
import Classes.Strategies.VKStrategy;
import Classes.TestObject;
import Games.BlackJack.BlackJackDeck;
import Games.BlackJack.DealerBlackjack;
import Games.BlackJack.UserBlackjack;
import org.junit.Test;

public class UnitTest {

  @Test
  public void TestDealerUser1() throws GameException {
    DealerBlackjack dealer = new DealerBlackjack();
    BlackJackDeck deck = new BlackJackDeck();
    UserBlackjack user = new UserBlackjack();

    deck.setSeed(6576987);

    dealer.refresh();
    user.refresh();
    deck.refresh();

    user.doStep("/take", deck);
    dealer.doStep(deck);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 14);
    assertEquals(dealer.getCurScore(), 16);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 23);
    assertEquals(dealer.getCurScore(), 23);

    String expectedUserHand = """
        DIAMONDS QUEEN 10
        DIAMONDS C4 4
        DIAMONDS C9 9
        """;
    String expectedDealerHand = """
        DIAMONDS KING 10
        DIAMONDS C6 6
        CLUBS C7 7
        """;
    assertEquals(expectedUserHand, user.showHand());
    assertEquals(expectedDealerHand, dealer.showHand());
  }

  @Test
  public void TestDealerUser2() throws GameException {
    DealerBlackjack dealer = new DealerBlackjack();
    BlackJackDeck deck = new BlackJackDeck();
    UserBlackjack user = new UserBlackjack();

    deck.setSeed(8755678);

    dealer.refresh();
    user.refresh();
    deck.refresh();

    user.doStep("/take", deck);
    dealer.doStep(deck);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 5);
    assertEquals(dealer.getCurScore(), 11);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 9);
    assertEquals(dealer.getCurScore(), 21);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 16);
    assertEquals(dealer.getCurScore(), 21);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 18);
    assertEquals(dealer.getCurScore(), 21);

    user.doStep("/wait", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 18);
    assertEquals(dealer.getCurScore(), 21);

    String expectedUserHand = """
        CLUBS C3 3
        SPADES C2 2
        HEARTS C4 4
        SPADES C7 7
        DIAMONDS C2 2
        """;
    String expectedDealerHand = """
        DIAMONDS C6 6
        DIAMONDS C5 5
        SPADES QUEEN 10
        """;
    assertEquals(expectedUserHand, user.showHand());
    assertEquals(expectedDealerHand, dealer.showHand());
  }

  @Test
  public void TestDealerUser3() throws GameException {
    DealerBlackjack dealer = new DealerBlackjack();
    BlackJackDeck deck = new BlackJackDeck();
    UserBlackjack user = new UserBlackjack();

    deck.setSeed(34569845);

    dealer.refresh();
    user.refresh();
    deck.refresh();

    user.doStep("/take", deck);
    dealer.doStep(deck);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 12);
    assertEquals(dealer.getCurScore(), 19);

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 14);
    assertEquals(dealer.getCurScore(), 19);

    user.doStep("/wait", deck);
    dealer.doStep(deck);
    assertEquals(user.getCurScore(), 14);
    assertEquals(dealer.getCurScore(), 19);

    String expectedUserHand = """
        HEARTS C2 2
        CLUBS VALET 10
        SPADES C2 2
        """;
    String expectedDealerHand = """
        CLUBS C10 10
        CLUBS C9 9
        """;
    assertEquals(expectedUserHand, user.showHand());
    assertEquals(expectedDealerHand, dealer.showHand());
  }

  @Test
  public void TestChooseStrategy() {
    ChooseStrategy strategy = new ChooseStrategy();
    Context context = new Context();

    context.setInput("return");
    String expectedResult1 = """
        Главное меню.
        Доступные опции:
            Количество сообщений в ВК /vk
            Игра в блэкджек /blackjack
            Игра в пьяницу /drunkman
            """;
    assertEquals(expectedResult1, strategy.exec(context));

    context.setInput("vk");
    String expectedResult2 = "Перейди по ссылке"
        + " https://oauth.vk.com/authorize?client_id=51489646&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=notifications&response_type=token&v=5.74, "
        + " введите токен, который находится в url-адрессе";
    assertEquals(expectedResult2, strategy.exec(context));

    context.setInput("exit");
    String expectedResult3 = "Завершение работы.";
    assertEquals(expectedResult3, strategy.exec(context));

    context.setInput("blackjack");
    String expectedResult4 = "";
    assertEquals(expectedResult4, strategy.exec(context));

    context.setInput("drunkman");
    String expectedResult5 = "";
    assertEquals(expectedResult5, strategy.exec(context));

    context.setInput("choose");
    String expectedResult6 = """
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу""";
    assertEquals(expectedResult6, strategy.exec(context));
  }

  @Test
  public void TestStartStrategy(){
    StartStrategy strategy = new StartStrategy();
    Context context = new Context();

    context.setInput("start");
    String expectedResult1 = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.""";
    assertEquals(expectedResult1, strategy.exec(context));

    context.setInput("help");
    String expectedResult2 = """
        --> /exit
         Логический выход из бота.
        --> /choose
         Переход в главное меню
            --> /vk
               Переход к командам VK логики. При выполнении дает ссылку, при переходе
               по которой можно будет получить токен для дальнейшей работы с VK
                 --> /count_unseen_chats
                       Возвращает количество чатов с непрочитанными сообщениями
            --> /blackjack
             Начинает игру в blackjack.
            --> /drunkman
        --> /return
         Возвращает в главное меню.
        """;
    assertEquals(expectedResult2, strategy.exec(context));

    context.setInput("choose");
    String expectedResult3 = """
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу""";
    assertEquals(expectedResult3, strategy.exec(context));

    context.setInput("exit");
    String expectedResult4 = "Завершение работы.";
    assertEquals(expectedResult4, strategy.exec(context));

    context.setInput("not_correct");
    String expectedResult5 = "Некорректный запрос. Попробую снова)";
    assertEquals(expectedResult5, strategy.exec(context));
  }

  @Test
  public void TestVKStrategy(){
    VKStrategy strategy = new VKStrategy(new TestObject());
    Context context = new Context();

    context.setInput("exit");
    String expectedResult1 = "Завершение работы.";
    assertEquals(expectedResult1, strategy.exec(context));

    context.setInput("return");
    String expectedResult2 = """
        Главное меню.
        Доступные опции:
            Количество сообщений в ВК /vk
            Игра в блэкджек /blackjack
            Игра в пьяницу /drunkman
            """;
    assertEquals(expectedResult2, strategy.exec(context));

    context.setInput("count_unseen_chats");
    String expectedResult3 = "Количество чатов с непрочитанными сообщениями: 2\n"
        + "Нажмите /choose или /help для продолжения";
    assertEquals(expectedResult3, strategy.exec(context));

    context.setInput("not_correct");
    String expectedResult4 = "Некорректный ввод токена. Попробуйте снова";
    assertEquals(expectedResult4, strategy.exec(context));
  }
}
