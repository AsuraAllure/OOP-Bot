package Console;

import Classes.InnerState;
import Interfaces.Factory;
import Interfaces.Reader;
import Interfaces.Writer;
import Classes.TEST_OBJECT;

public class ConsoleBot {

  private Reader rd;
  private Writer wr;
  private final InnerState is;

  public ConsoleBot(Factory fc) {
    this.rd = fc.getReader();
    this.wr = fc.getWriter();
    is = new InnerState(new TEST_OBJECT(523));

  }

  public void run() {
    do {
      String input = rd.read();
      String output = is.execCommand(input);
      wr.writeln(output);
    } while (!is.isExit());
    is.sayGoodbye();
  }
}