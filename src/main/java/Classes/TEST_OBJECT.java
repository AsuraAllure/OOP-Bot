package Classes;

public class TEST_OBJECT {

  private final long seed;

  public TEST_OBJECT(long a) {
    seed = a;
  }

  public TEST_OBJECT() {
    seed = -1;
  }

  public long getSeed() {
    return seed;
  }
}
