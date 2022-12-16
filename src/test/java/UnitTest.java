
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import CardGame.GameException;
import Classes.Contexts.Context;
import Classes.Strategies.BJStrategy;
import Classes.Strategies.ChooseStrategy;
import Classes.Strategies.DrunkManStrategy;
import Classes.Strategies.StartStrategy;
import Classes.Strategies.VKStrategy;
import Classes.TestObject;
import Enums.State;
import Games.BlackJack.BlackJackDeck;
import Games.BlackJack.DealerBlackjack;
import Games.BlackJack.UserBlackjack;
import java.util.ArrayList;
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
    assertEquals(14, user.getCurScore());
    assertEquals(16, dealer.getCurScore());

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(23, user.getCurScore());
    assertEquals(23, dealer.getCurScore());

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
    assertEquals(5, user.getCurScore());
    assertEquals(11, dealer.getCurScore());

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(9, user.getCurScore());
    assertEquals(21, dealer.getCurScore());

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(16, user.getCurScore());
    assertEquals(21, dealer.getCurScore());

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(18, user.getCurScore());
    assertEquals(21, dealer.getCurScore());

    user.doStep("/wait", deck);
    dealer.doStep(deck);
    assertEquals(18, user.getCurScore());
    assertEquals(21, dealer.getCurScore());

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
    assertEquals(12, user.getCurScore());
    assertEquals(19, dealer.getCurScore());

    user.doStep("/take", deck);
    dealer.doStep(deck);
    assertEquals(14, user.getCurScore());
    assertEquals(19, dealer.getCurScore());

    user.doStep("/wait", deck);
    dealer.doStep(deck);
    assertEquals(14, user.getCurScore());
    assertEquals(19, dealer.getCurScore());

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
    String expectedOutput1 = """
        Главное меню.
        Доступные опции:
            Количество сообщений в ВК /vk
            Игра в блэкджек /blackjack
            Игра в пьяницу /drunkman
            """;
    assertEquals(expectedOutput1, strategy.exec(context));
    ArrayList<String> availableCommands1 = context.getAvailableCommands();
    ArrayList<String> expectedAvail1 = new ArrayList<>();
    expectedAvail1.add("vk");
    expectedAvail1.add("blackjack");
    expectedAvail1.add("drunkman");
    assertArrayEquals(new ArrayList[]{expectedAvail1}, new ArrayList[]{availableCommands1});
    assertEquals(State.CHOOSE, context.getPrevState());


    context.setInput("vk");
    String expectedOutput2 = "Перейди по ссылке"
        + " https://oauth.vk.com/authorize?client_id=51489646&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=notifications&response_type=token&v=5.74, "
        + " введите токен, который находится в url-адрессе";
    assertEquals(expectedOutput2, strategy.exec(context));
    ArrayList<String> availableCommands2 = context.getAvailableCommands();
    ArrayList<String> expectedAvail2 = new ArrayList<>();
    expectedAvail2.add("return");
    expectedAvail2.add("exit");
    assertArrayEquals(new ArrayList[]{expectedAvail2}, new ArrayList[]{availableCommands2});


    context.setInput("exit");
    String expectedOutput3 = "Завершение работы.";
    assertEquals(expectedOutput3, strategy.exec(context));
    ArrayList<String> availableCommands3 = context.getAvailableCommands();
    ArrayList<String> expectedAvail3 = new ArrayList<>();
    expectedAvail3.add("return");
    expectedAvail3.add("exit");
    assertArrayEquals(new ArrayList[]{expectedAvail3}, new ArrayList[]{availableCommands3});

    context.setInput("blackjack");
    String expectedOutput4 = "";
    assertEquals(expectedOutput4, strategy.exec(context));
    ArrayList<String> availableCommands4 = context.getAvailableCommands();
    ArrayList<String> expectedAvail4 = new ArrayList<>();
    expectedAvail4.add("wait");
    expectedAvail4.add("take");
    assertArrayEquals(new ArrayList[]{expectedAvail4}, new ArrayList[]{availableCommands4});
    assertEquals(State.PLAY_BLACKJACK, context.getPrevState());

    context.setInput("drunkman");
    String expectedOutput5 = "";
    assertEquals(expectedOutput5, strategy.exec(context));
    ArrayList<String> availableCommands5 = context.getAvailableCommands();
    ArrayList<String> expectedAvail5 = new ArrayList<>();
    expectedAvail5.add("wait");
    expectedAvail5.add("take");
    assertArrayEquals(new ArrayList[]{expectedAvail5}, new ArrayList[]{availableCommands5});
    assertEquals(State.PLAY_DRUNKMAN, context.getPrevState());

    context.setInput("choose");
    String expectedOutput6 = """
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу""";
    assertEquals(expectedOutput6, strategy.exec(context));
    ArrayList<String> availableCommands6 = context.getAvailableCommands();
    ArrayList<String> expectedAvail6 = new ArrayList<>();
    expectedAvail6.add("vk");
    expectedAvail6.add("blackjack");
    expectedAvail6.add("drunkman");
    assertArrayEquals(new ArrayList[]{expectedAvail6}, new ArrayList[]{availableCommands6});
    assertEquals(State.CHOOSE, context.getPrevState());
  }

  @Test
  public void TestStartStrategy() {
    StartStrategy strategy = new StartStrategy();
    Context context = new Context();

    context.setInput("start");
    String expectedOutput1 = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.""";
    assertEquals(expectedOutput1, strategy.exec(context));
    ArrayList<String> availableCommands1 = context.getAvailableCommands();
    ArrayList<String> expectedAvail1 = new ArrayList<>();
    expectedAvail1.add("choose");
    expectedAvail1.add("help");
    assertArrayEquals(new ArrayList[]{expectedAvail1}, new ArrayList[]{availableCommands1});
    assertEquals(State.EMPTY, context.getPrevState());

    context.setInput("help");
    String expectedOutput2 = """
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
    assertEquals(expectedOutput2, strategy.exec(context));
    ArrayList<String> availableCommands2 = context.getAvailableCommands();
    ArrayList<String> expectedAvail2 = new ArrayList<>();
    expectedAvail2.add("exit");
    expectedAvail2.add("choose");
    expectedAvail2.add("return");
    assertArrayEquals(new ArrayList[]{expectedAvail2}, new ArrayList[]{availableCommands2});
    assertEquals(State.EMPTY, context.getPrevState());

    context.setInput("choose");
    String expectedOutput3 = """
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу""";
    assertEquals(expectedOutput3, strategy.exec(context));
    ArrayList<String> availableCommands3 = context.getAvailableCommands();
    ArrayList<String> expectedAvail3 = new ArrayList<>();
    expectedAvail3.add("vk");
    expectedAvail3.add("blackjack");
    expectedAvail3.add("drunkman");
    assertArrayEquals(new ArrayList[]{expectedAvail3}, new ArrayList[]{availableCommands3});
    assertEquals(State.CHOOSE, context.getPrevState());

    context.setInput("exit");
    String expectedOutput4 = "Завершение работы.";
    assertEquals(expectedOutput4, strategy.exec(context));
    ArrayList<String> availableCommands4 = context.getAvailableCommands();
    ArrayList<String> expectedAvail4 = new ArrayList<>();
    assertArrayEquals(new ArrayList[]{expectedAvail4}, new ArrayList[]{availableCommands4});
    assertEquals(State.EMPTY, context.getPrevState());

    context.setInput("notCorrect");
    String expectedOutput5 = "Некорректный запрос. Попробую снова)";
    assertEquals(expectedOutput5, strategy.exec(context));
    ArrayList<String> availableCommands5 = context.getAvailableCommands();
    ArrayList<String> expectedAvail5 = new ArrayList<>();
    expectedAvail5.add("start");
    assertArrayEquals(new ArrayList[]{expectedAvail5}, new ArrayList[]{availableCommands5});
  }

  @Test
  public void TestVKStrategy() {
    VKStrategy strategy = new VKStrategy(new TestObject());
    Context context = new Context();

    context.setInput("exit");
    String expectedOutput1 = "Завершение работы.";
    assertEquals(expectedOutput1, strategy.exec(context));
    ArrayList<String> availableCommands1 = context.getAvailableCommands();
    ArrayList<String> expectedAvail1 = new ArrayList<>();
    assertArrayEquals(new ArrayList[]{expectedAvail1}, new ArrayList[]{availableCommands1});
    assertEquals(State.EMPTY, context.getPrevState());

    context.setInput("return");
    String expectedOutput2 = """
        Главное меню.
        Доступные опции:
            Количество сообщений в ВК /vk
            Игра в блэкджек /blackjack
            Игра в пьяницу /drunkman
            """;
    assertEquals(expectedOutput2, strategy.exec(context));
    ArrayList<String> availableCommands2 = context.getAvailableCommands();
    ArrayList<String> expectedAvail2 = new ArrayList<>();
    expectedAvail2.add("vk");
    expectedAvail2.add("blackjack");
    expectedAvail2.add("drunkman");
    assertArrayEquals(new ArrayList[]{expectedAvail2}, new ArrayList[]{availableCommands2});
    assertEquals(State.CHOOSE, context.getPrevState());

    context.setInput("count_unseen_chats");
    String expectedResult3 = "Количество чатов с непрочитанными сообщениями: 2\n"
        + "Нажмите /choose или /help для продолжения";
    assertEquals(expectedResult3, strategy.exec(context));
    ArrayList<String> availableCommands3 = context.getAvailableCommands();
    ArrayList<String> expectedAvail3 = new ArrayList<>();
    expectedAvail3.add("choose");
    expectedAvail3.add("help");
    assertArrayEquals(new ArrayList[]{expectedAvail3}, new ArrayList[]{availableCommands3});
    assertEquals(State.EMPTY, context.getPrevState());

    context.setInput("notCorrect");
    String expectedResult4 = "Некорректный ввод токена. Попробуйте снова";
    assertEquals(expectedResult4, strategy.exec(context));
    ArrayList<String> availableCommands4 = context.getAvailableCommands();
    ArrayList<String> expectedAvail4 = new ArrayList<>();
    expectedAvail4.add("choose");
    expectedAvail4.add("help");
    assertArrayEquals(new ArrayList[]{expectedAvail4}, new ArrayList[]{availableCommands4});
  }

  @Test
  public void TestBJStrategy(){
    BJStrategy strategy = new BJStrategy(new TestObject(8755678));
    Context context = new Context();

    context.setInput("exit");
    String expectedOutput1 = "Завершение работы.";
    assertEquals(expectedOutput1, strategy.exec(context));
    assertTrue(context.getExitState());
    ArrayList<String> availableCommands1 = context.getAvailableCommands();
    ArrayList<String> expectedAvail1 = new ArrayList<>();
    assertArrayEquals(new ArrayList[]{expectedAvail1}, new ArrayList[]{availableCommands1});
    assertEquals(State.EMPTY, context.getPrevState());

    context.setInput("return");
    String expectedOutput2 = """
        Главное меню.
        Доступные опции:
            Количество сообщений в ВК /vk
            Игра в блэкджек /blackjack
            Игра в пьяницу /drunkman
            """;
    assertEquals(expectedOutput2, strategy.exec(context));
    assertEquals(State.CHOOSE, context.getPrevState());
    ArrayList<String> availableCommands2 = context.getAvailableCommands();
    ArrayList<String> expectedAvail2 = new ArrayList<>();
    expectedAvail2.add("vk");
    expectedAvail2.add("blackjack");
    expectedAvail2.add("drunkman");
    assertArrayEquals(new ArrayList[]{expectedAvail2}, new ArrayList[]{availableCommands2});

    context.setInput("correctInput");
    strategy.exec(context);
    assertTrue(strategy.getDist());

    strategy.setDist(true);
    context.setInput("notCorrectInput");
    String expectedResult3 = "Некорректный запрос. Попробую снова)";
    assertEquals(expectedResult3, strategy.exec(context));
  }

  @Test
  public void TestDrunkManStrategy(){
    DrunkManStrategy strategy = new DrunkManStrategy();
    Context context = new Context();

    context.setInput("exit");
    String expectedOutput1 = "Завершение работы.";
    assertEquals(expectedOutput1, strategy.exec(context));
    assertTrue(context.getExitState());
    ArrayList<String> availableCommands1 = context.getAvailableCommands();
    ArrayList<String> expectedAvail1 = new ArrayList<>();
    assertArrayEquals(new ArrayList[]{expectedAvail1}, new ArrayList[]{availableCommands1});
    assertEquals(State.EMPTY, context.getPrevState());

    context.setInput("return");
    String expectedOutput2 = """
        Главное меню.
        Доступные опции:
            Количество сообщений в ВК /vk
            Игра в блэкджек /blackjack
            Игра в пьяницу /drunkman
            """;
    assertEquals(expectedOutput2, strategy.exec(context));
    assertEquals(State.CHOOSE, context.getPrevState());
    ArrayList<String> availableCommands2 = context.getAvailableCommands();
    ArrayList<String> expectedAvail2 = new ArrayList<>();
    expectedAvail2.add("vk");
    expectedAvail2.add("blackjack");
    expectedAvail2.add("drunkman");
    assertArrayEquals(new ArrayList[]{expectedAvail2}, new ArrayList[]{availableCommands2});

    context.setInput("notCorrectInput");
    String expectedResult3 = "Некорректный запрос. Попробую снова)";
    assertEquals(expectedResult3, strategy.exec(context));

    context.setInput("play");
    strategy.exec(context);
    ArrayList<String> availableCommands4 = context.getAvailableCommands();
    ArrayList<String> expectedAvail4 = new ArrayList<>();
    expectedAvail4.add("play");
    expectedAvail4.add("return");
    assertArrayEquals(new ArrayList[]{expectedAvail4}, new ArrayList[]{availableCommands4});
    assertEquals(State.PLAY_DRUNKMAN, context.getPrevState());
  }
}
