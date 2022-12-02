package VK;

public class VKParser {

  private boolean isDigit(char c) {
    switch (c) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
        return true;
    }
    return false;
  }

  public String selectCountChats(String data) {

    int a = data.indexOf("messages") + "messages".length() + 1;
    StringBuilder count = new StringBuilder();
    while (isDigit(data.charAt(a + 1))) {
      count.append(data.charAt(a + 1));
      a += 1;
    }
    if (count.length() == 0) {
      count.append('0');
    }
    return count.toString();
  }
}
