import static org.junit.Assert.assertEquals;

import Classes.InnerState;
import Classes.MessageBox;
import Classes.TestObject;
import org.junit.Test;

//  Для тестирования опции блэкджека необходимо установить seed, для контролируемого поведения


public class FunctionalTest {

  private String testOutput(InnerState s, String nameTestFile) {
    TestReader tr = new TestReader(nameTestFile);
    String result = "";
    String input = "";
    do {
      try {
        input = tr.read();
      } catch (IndexOutOfBoundsException e) {
        break;
      }
      if (input == "") {
        input = "/exit";
      }
      String output = s.execCommand(input);
      result += output + '\n';
    } while (!s.isExit());
    return result;
  }

  @Test
  public void Test1() {
    InnerState in = new InnerState(new TestObject(12634));  // Сид помещать в TEST_OBJECT
    MessageBox mb = new MessageBox();
    String testOutput = testOutput(in, "src/test/java/TestFile/Test1");
    String realExpectedOutput =
        mb.getStart() + '\n' + mb.getHelp() + '\n' + mb.getChoiceOfMessenger() + '\n'
            + mb.getVkToken() + '\n' + mb.getVKCommand() + '\n' + mb.countChatsMessage() + "2"
            + mb.getVKCommand2() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOutput, testOutput);
  }

  @Test
  public void Test2() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/TestFile/Test2");
    MessageBox mb = new MessageBox();
    String realExpectedOutput =
        mb.getIncorrectCommand() + '\n' + mb.getHelp() + '\n' + mb.getChoiceOfMessenger() + '\n'
            + mb.getIncorrectCommand() + '\n' + mb.getIncorrectCommand() + '\n' + mb.getGoodbye()
            + '\n';
    assertEquals(realExpectedOutput, testOutput);
  }


  @Test
  public void Test3() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/TestFile/Test3");
    MessageBox mb = new MessageBox();
    String realExpectedOutput =
        mb.getHelp() + '\n' + mb.getIncorrectCommand() + '\n' + mb.getChoiceOfMessenger() + '\n'
            + mb.getIncorrectCommand() + '\n' + mb.getIncorrectCommand() + '\n' + mb.getGoodbye()
            + '\n';
    assertEquals(realExpectedOutput, testOutput);
  }


  @Test
  public void Test4() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/TestFile/Test4");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getIncorrectCommand() + '\n' + mb.getGoodbye() + '\n';

    assertEquals(realExpectedOut, testOutput);
  }


  @Test
  public void Test5() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/TestFile/Test5");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getChoiceOfMessenger() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test6() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/TestFile/Test6");
    MessageBox mb = new MessageBox();
    String realExpectedOut =
        mb.getChoiceOfMessenger() + '\n' + mb.getVkToken() + '\n' + mb.getVKCommand() + '\n'
            + mb.countChatsMessage() + "2" + mb.getVKCommand2() + '\n' + mb.getHelp() + '\n'
            + mb.getChoiceOfMessenger() + '\n' + mb.getIncorrectCommand() + '\n'
            + mb.getIncorrectCommand() + '\n' + mb.getIncorrectCommand() + '\n';
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test7() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/TestFile/Test7");
    MessageBox mb = new MessageBox();
    String realExpectedOut =
        mb.getIncorrectCommand() + '\n' + mb.getStart() + '\n' + mb.getChoiceOfMessenger() + '\n'
            + mb.getVkToken() + '\n' + mb.getIncorrectToken() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test8() {
    InnerState in = new InnerState(new TestObject(3232));
    String testOutput = testOutput(in, "src/test/java/TestFile/Test8");
    String realExpectedOutput = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        Начинается партия.
        В каждой строке будет отображаться карта в формате:
        МАСТЬ ЗНАЧЕНИЕ НОМИНАЛ

        В случае выпадение туза, введите его значение: 1 или 11

        Dealer:
        CLUBS C10 10
        SPADES C7 7
        Счет Ведущего: 17
        User:
        HEARTS C4 4
        DIAMONDS C3 3
        Счет Игрока: 7
        Dealer:
        CLUBS C10 10
        SPADES C7 7
        Счет Ведущего: 17
        User:
        HEARTS C4 4
        DIAMONDS C3 3
        SPADES QUEEN 10
        Счет Игрока: 17
        Dealer:
        CLUBS C10 10
        SPADES C7 7
        Счет Ведущего: 17
        User:
        HEARTS C4 4
        DIAMONDS C3 3
        SPADES QUEEN 10
        Счет Игрока: 17. Cчёт ведущего: 17 Ничья.

        Вы завершили партию. Нажмите /blackjack для продолжения, или /choose для выхода в главное меню
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        Завершение работы.
        """;
    assertEquals(realExpectedOutput, testOutput);
  }

  @Test
  public void Test9() {
    InnerState in = new InnerState(new TestObject(987654));
    MessageBox mb = new MessageBox();
    String testOutput = testOutput(in, "src/test/java/TestFile/Test9");
    String realExpectedOutput = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        Начинается партия.
        В каждой строке будет отображаться карта в формате:
        МАСТЬ ЗНАЧЕНИЕ НОМИНАЛ
                
        В случае выпадение туза, введите его значение: 1 или 11
                
        Dealer:
        HEARTS KING 10
        SPADES C3 3
        Счет Ведущего: 13
        User:
        SPADES C8 8
        DIAMONDS C3 3
        Счет Игрока: 11
        Dealer:
        HEARTS KING 10
        SPADES C3 3
        HEARTS C2 2
        Счет Ведущего: 15
        User:
        SPADES C8 8
        DIAMONDS C3 3
        HEARTS C3 3
        Счет Игрока: 14
        Dealer:
        HEARTS KING 10
        SPADES C3 3
        HEARTS C2 2
        DIAMONDS C5 5
        Счет Ведущего: 20
        User:
        SPADES C8 8
        DIAMONDS C3 3
        HEARTS C3 3
        CLUBS C2 2
        Счет Игрока: 16
        Dealer:
        HEARTS KING 10
        SPADES C3 3
        HEARTS C2 2
        DIAMONDS C5 5
        Счет Ведущего: 20
        User:
        SPADES C8 8
        DIAMONDS C3 3
        HEARTS C3 3
        CLUBS C2 2
        CLUBS C10 10
        Счет Игрока: 26. Cчёт ведущего: 20 Вы проиграли.
                
        Вы завершили партию. Нажмите /blackjack для продолжения, или /choose для выхода в главное меню
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        Завершение работы.
        """;
    assertEquals(realExpectedOutput, testOutput);
  }

  @Test
  public void Test10() {
    InnerState in = new InnerState(new TestObject(56453));
    String testOutput = testOutput(in, "src/test/java/TestFile/Test10");
    String realExpectedOut = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        Начинается партия.
        В каждой строке будет отображаться карта в формате:
        МАСТЬ ЗНАЧЕНИЕ НОМИНАЛ

        В случае выпадение туза, введите его значение: 1 или 11

        Dealer:
        DIAMONDS C10 10
        SPADES KING 10
        Счет Ведущего: 20
        User:
        CLUBS C6 6
        CLUBS C5 5
        Счет Игрока: 11
        Некорректный запрос. Попробую снова)
        Dealer:
        DIAMONDS C10 10
        SPADES KING 10
        Счет Ведущего: 20
        User:
        CLUBS C6 6
        CLUBS C5 5
        Счет Игрока: 11. Cчёт ведущего: 20 Вы проиграли.

        Вы завершили партию. Нажмите /blackjack для продолжения, или /choose для выхода в главное меню
        Завершение работы.
        """;
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test11() {
    InnerState in = new InnerState(new TestObject(252));
    String testOutput = testOutput(in, "src/test/java/TestFile/Test11");
    String realExpectedOut = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        HEARTS C6
        DIAMONDS C10
        Вы проиграли раунд
        У вас 17 карт
        У ведущего 19 карт
        DIAMONDS C7
        CLUBS KING
        Вы проиграли раунд
        У вас 16 карт
        У ведущего 20 карт
        SPADES QUEEN
        DIAMONDS KING
        Вы проиграли раунд
        У вас 15 карт
        У ведущего 21 карт
        DIAMONDS ACE
        SPADES ACE
        HEARTS KING
        SPADES KING
        SPADES C9
        DIAMONDS QUEEN
        Вы проиграли раунд
        У вас 12 карт
        У ведущего 24 карт
        SPADES C8
        CLUBS VALET
        Вы проиграли раунд
        У вас 11 карт
        У ведущего 25 карт
        CLUBS C7
        CLUBS QUEEN
        Вы проиграли раунд
        У вас 10 карт
        У ведущего 26 карт
        DIAMONDS C6
        CLUBS C9
        Вы проиграли раунд
        У вас 9 карт
        У ведущего 27 карт
        HEARTS C7
        DIAMONDS C8
        Вы проиграли раунд
        У вас 8 карт
        У ведущего 28 карт
        SPADES C7
        CLUBS C10
        Вы проиграли раунд
        У вас 7 карт
        У ведущего 29 карт
        HEARTS C9
        DIAMONDS VALET
        Вы проиграли раунд
        У вас 6 карт
        У ведущего 30 карт
        SPADES C10
        CLUBS ACE
        Вы проиграли раунд
        У вас 5 карт
        У ведущего 31 карт
        SPADES C6
        DIAMONDS C9
        Вы проиграли раунд
        У вас 4 карт
        У ведущего 32 карт
        HEARTS VALET
        HEARTS QUEEN
        Вы проиграли раунд
        У вас 3 карт
        У ведущего 33 карт
        HEARTS C10
        CLUBS C6
        Вы выйграли раунд
        У вас 4 карт
        У ведущего 32 карт
        CLUBS C8
        HEARTS ACE
        Вы проиграли раунд
        У вас 3 карт
        У ведущего 33 карт
        HEARTS C8
        SPADES VALET
        Вы проиграли раунд
        У вас 2 карт
        У ведущего 34 карт
        HEARTS C10
        HEARTS C6
        Вы выйграли раунд
        У вас 3 карт
        У ведущего 33 карт
        CLUBS C6
        DIAMONDS C10
        Вы проиграли раунд
        У вас 2 карт
        У ведущего 34 карт
        HEARTS C10
        DIAMONDS C7
        Вы выйграли раунд
        У вас 3 карт
        У ведущего 33 карт
        HEARTS C6
        CLUBS KING
        Вы проиграли раунд
        У вас 2 карт
        У ведущего 34 карт
        HEARTS C10
        SPADES QUEEN
        Вы проиграли раунд
        У вас 1 карт
        У ведущего 35 карт
        DIAMONDS C7
        DIAMONDS KING

        Вы проиграли
        Завершение работы.
        """;
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test12() {
    InnerState in = new InnerState(new TestObject(3452));
    String testOutput = testOutput(in, "src/test/java/TestFile/Test12");
    String realExpectedOut = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        DIAMONDS C7
        CLUBS C10
        Вы проиграли раунд
        У вас 17 карт
        У ведущего 19 карт
        DIAMONDS ACE
        SPADES QUEEN
        Вы выйграли раунд
        У вас 18 карт
        У ведущего 18 карт
        SPADES ACE
        CLUBS C7
        Вы выйграли раунд
        У вас 19 карт
        У ведущего 17 карт
        DIAMONDS C9
        SPADES C10
        Вы проиграли раунд
        У вас 18 карт
        У ведущего 18 карт
        CLUBS KING
        HEARTS ACE
        Вы проиграли раунд
        У вас 17 карт
        У ведущего 19 карт
        DIAMONDS VALET
        DIAMONDS QUEEN
        Вы проиграли раунд
        У вас 16 карт
        У ведущего 20 карт
        CLUBS VALET
        DIAMONDS C8
        Вы выйграли раунд
        У вас 17 карт
        У ведущего 19 карт
        Завершение работы.
        """;
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test13() {
    InnerState in = new InnerState(new TestObject(54654));
    String testOutput = testOutput(in, "src/test/java/TestFile/Test13");
    String realExpectedOut = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
           /drunkman, если хочешь начать игру в пьяницу
        HEARTS C9
        SPADES C7
        Вы выйграли раунд
        У вас 19 карт
        У ведущего 17 карт
        CLUBS VALET
        HEARTS C10
        Вы выйграли раунд
        У вас 20 карт
        У ведущего 16 карт
        Некорректный запрос. Попробую снова)
        DIAMONDS C7
        CLUBS KING
        Вы проиграли раунд
        У вас 19 карт
        У ведущего 17 карт
        HEARTS KING
        SPADES C10
        Вы выйграли раунд
        У вас 20 карт
        У ведущего 16 карт
        Завершение работы.
        """;
    assertEquals(realExpectedOut, testOutput);
  }
}
