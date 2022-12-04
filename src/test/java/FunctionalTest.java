import static org.junit.Assert.assertEquals;

import Classes.InnerState;
import Classes.MessageBox;
import Classes.TEST_OBJECT;
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
    InnerState in = new InnerState(new TEST_OBJECT(12634));  // Сид помещать в TEST_OBJECT
    MessageBox mb = new MessageBox();
    String testOutput = testOutput(in, "src/test/java/Test1");
    String realExpectedOutput = mb.getStart() + '\n' + mb.getHelp() + '\n' +
        mb.getChoiceOfMessenger() + '\n' + mb.getVkToken() + '\n' +
        mb.getVKCommand() + '\n' + mb.countChatsMessage() + "2" + mb.getVKCommand2() + '\n' +
        mb.getGoodbye() + '\n';

    assertEquals(realExpectedOutput, testOutput);
  }

  @Test
  public void Test2() {
    InnerState in = new InnerState(new TEST_OBJECT());
    String testOutput = testOutput(in, "src/test/java/Test2");
    MessageBox mb = new MessageBox();
    String realExpectedOutput = mb.getIncorrectCommand() + '\n' + mb.getHelp() + '\n' +
        mb.getChoiceOfMessenger() + '\n' + mb.getIncorrectCommand() + '\n' +
        mb.getIncorrectCommand() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOutput, testOutput);
  }


  @Test
  public void Test3() {
    InnerState in = new InnerState(new TEST_OBJECT());
    String testOutput = testOutput(in, "src/test/java/Test3");
    MessageBox mb = new MessageBox();
    String realExpectedOutput = mb.getHelp() + '\n' + mb.getIncorrectCommand() + '\n' +
        mb.getChoiceOfMessenger() + '\n' + mb.getIncorrectCommand() + '\n' +
        mb.getIncorrectCommand() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOutput, testOutput);
  }


  @Test
  public void Test4() {
    InnerState in = new InnerState(new TEST_OBJECT());
    String testOutput = testOutput(in, "src/test/java/Test4");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getIncorrectCommand() + '\n' + mb.getGoodbye() + '\n';

    assertEquals(realExpectedOut, testOutput);
  }


  @Test
  public void Test5() {
    InnerState in = new InnerState(new TEST_OBJECT());
    String testOutput = testOutput(in, "src/test/java/Test5");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getChoiceOfMessenger() + '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test6() {
    InnerState in = new InnerState(new TEST_OBJECT());
    String testOutput = testOutput(in, "src/test/java/Test6");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getChoiceOfMessenger() + '\n' + mb.getVkToken() + '\n' +
        mb.getVKCommand() + '\n' + mb.countChatsMessage() +
        "2" + mb.getVKCommand2() + '\n' + mb.getHelp() + '\n' + mb.getChoiceOfMessenger() + '\n' +
        mb.getIncorrectCommand() + '\n' + mb.getIncorrectCommand() + '\n' + mb.getIncorrectCommand()
        + '\n';
    assertEquals(realExpectedOut, testOutput);
  }

  @Test
  public void Test7() {
    InnerState in = new InnerState(new TEST_OBJECT());
    String testOutput = testOutput(in, "src/test/java/Test7");
    MessageBox mb = new MessageBox();
    String realExpectedOut = mb.getIncorrectCommand() + '\n' + mb.getStart() + '\n' +
        mb.getChoiceOfMessenger() + '\n' + mb.getVkToken() + '\n' + mb.getIncorrectToken() +
        '\n' + mb.getGoodbye() + '\n';
    assertEquals(realExpectedOut, testOutput);
  }
}
