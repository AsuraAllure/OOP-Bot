package VK;

public class TEST_VK extends VK {

  public boolean setToken(String str) {
    return !(str.contentEquals("correctToken"));
  }

  public String countUnseenChats() {
    return "2";
  }
}
