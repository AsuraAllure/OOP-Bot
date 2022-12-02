import Interfaces.Factory;

public class TestFactory implements Factory {

  private final TestReader tr;
  private final TestWriter tw;

  public TestFactory(String nameTestFile) {
    this.tr = new TestReader(nameTestFile);
    this.tw = new TestWriter();
  }

  @Override
  public TestReader getReader() {
    return this.tr;
  }

  @Override
  public TestWriter getWriter() {
    return this.tw;
  }
}
