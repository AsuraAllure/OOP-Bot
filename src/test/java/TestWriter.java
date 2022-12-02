import Interfaces.Writer;

public class TestWriter implements Writer {

  private StringBuilder testOut;

  public TestWriter() {
    testOut = new StringBuilder();
  }

  public String writeln(String str) {
    testOut.append(str + '\n');
    return str;
  }

  public void write(String str) {
    testOut.append(str);
  }

  public String getTestOut() {
    return testOut.toString();
  }

}
