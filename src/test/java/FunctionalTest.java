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
    String testOutput = testOutput(in, "src/test/java/Test1");
    String realExpectedOutput =
        mb.getStart() + '\n' + mb.getHelp() + '\n' + mb.getChoiceOfMessenger() + '\n'
            + mb.getVkToken() + '\n' + mb.getVKCommand() + '\n' + mb.countChatsMessage() + "2"
            + mb.getVKCommand2() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOutput, testOutput);
  }

  @Test
  public void Test2() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/Test2");
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
    String testOutput = testOutput(in, "src/test/java/Test3");
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
    String testOutput = testOutput(in, "src/test/java/Test4");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getIncorrectCommand() + '\n' + mb.getGoodbye() + '\n';

    assertEquals(realExpectedOut, testOutput);
  }


  @Test
  public void Test5() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/Test5");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getChoiceOfMessenger() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test6() {
    InnerState in = new InnerState(new TestObject());
    String testOutput = testOutput(in, "src/test/java/Test6");
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
    String testOutput = testOutput(in, "src/test/java/Test7");
    MessageBox mb = new MessageBox();
    String realExpectedOut =
        mb.getIncorrectCommand() + '\n' + mb.getStart() + '\n' + mb.getChoiceOfMessenger() + '\n'
            + mb.getVkToken() + '\n' + mb.getIncorrectToken() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test8() {
    InnerState in = new InnerState(new TestObject(3232));
    String testOutput = testOutput(in, "src/test/java/Test8");
    String realExpectedOutput = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
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
        Завершение работы.
        """;
    assertEquals(realExpectedOutput, testOutput);
  }

  @Test
  public void Test9() {
    InnerState in = new InnerState(new TestObject(987654));
    MessageBox mb = new MessageBox();
    String testOutput = testOutput(in, "src/test/java/Test9");
    String realExpectedOutput = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
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
        Завершение работы.
        """;
    assertEquals(realExpectedOutput, testOutput);
  }

  @Test
  public void Test10() {
    InnerState in = new InnerState(new TestObject(56453));
    String testOutput = testOutput(in, "src/test/java/Test10");
    String realExpectedOut = """
        Привет!
        Главное меню: /choose.
        Документация команд: /help.
        Жми /vk, если хочешь подключиться к Вконтакте
           /blackjack, если хочешь начать игру в blackjack
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
}
