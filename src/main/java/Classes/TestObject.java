package Classes;

public class TestObject {

  private final long seed;

  public TestObject(long a) {
    seed = a;
  }

  public TestObject() {
    seed = -1;
  }

  public long getSeed() {
    return seed;
  }
}
