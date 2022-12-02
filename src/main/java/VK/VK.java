package VK;

import java.io.*;
import java.net.*;


public class VK {

  private String tokenNotifications;
  private String urlReq;

  public VK() {
    this.tokenNotifications = "";
  }

  public boolean setToken(String token) {
    this.tokenNotifications = token;
    return checkToken();
  }

  private boolean checkToken() {
    // Некорректный адрес
    this.urlReq = "https://api.vk.com/method/account.getCounters?&access_token="
        + tokenNotifications + "&v=5.131";
    String data = getVkData(urlReq);
      if (data.indexOf("error") == -1) {
          return false;
      }
    return true;
  }

  private String getVkData(String urlReq) {
    String urlString = "";
    try {
      URL url = new URL(urlReq);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      BufferedReader in = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
      String current;

      while ((current = in.readLine()) != null) {
        urlString += current;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return urlString;
  }

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

  private String selectCountChats(String data) {

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

  public String countUnseenChats() {
    this.urlReq = "https://api.vk.com/method/account.getCounters?&access_token="
        + tokenNotifications + "&v=5.131";
    String vkData = getVkData(urlReq);
    return selectCountChats(vkData);
  }

}
