package Console;

import Classes.InnerState;
import Classes.TestObject;
import Interfaces.Factory;
import Interfaces.Reader;
import Interfaces.Writer;

public class ConsoleBot {

  private final InnerState is;
  private final Reader rd;
  private final Writer wr;

  public ConsoleBot(Factory fc) {
    this.rd = fc.getReader();
    this.wr = fc.getWriter();
    is = new InnerState(new TestObject(54654));
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