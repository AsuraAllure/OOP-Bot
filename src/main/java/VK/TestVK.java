package VK;

public class TestVK extends VK {

  public boolean setToken(String str) {
    return !(str.contentEquals("correctToken"));
  }

  public String countUnseenChats() {
    return "2";
  }
}
