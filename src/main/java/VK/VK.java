package VK;

import java.io.*;
import java.net.*;


public class VK {

  private String tokenNotifications;
  private String urlReq;

  private VKParser parser;
  public VK() {
    this.parser = new VKParser();
    this.tokenNotifications = "";
  }

  public boolean setToken(String token) {
    this.tokenNotifications = token;
    return checkToken();
  }
  private boolean checkToken() {
    // Некорректный адрес
    this.urlReq = "https://api.vk.com/method/account.getCounter"
        + "s?&access_token="
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
  public String countUnseenChats() {
    this.urlReq = "https://api.vk.com/method/account.getCounters?&access_token="
        + tokenNotifications + "&v=5.131";
    String vkData = getVkData(urlReq);
    return parser.selectCountChats(vkData);
  }

}
