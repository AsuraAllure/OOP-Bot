package VK;
import java.io.* ;
import java.net.*;


public class VK {
    private String token_notifications;
    private String url_req ;
    public VK(){
        this.token_notifications = "";
    }

    public boolean set_token(String token){
        this.token_notifications = token;
        return check_token();
    }
    private boolean check_token(){
        // Некорректный адрес
        this.url_req =  "https://api.vk.com/method/account.getCounters?&access_token="
                + token_notifications + "&v=5.131";
        String data = get_VK_data(url_req);
        if (data.indexOf("error") == -1)
            return false;
        return true;
    }


    private String get_VK_data(String url_req){
        String url_string = "";
        try {
            URL url = new URL(url_req);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String current;

            while((current = in.readLine()) != null) {
                url_string += current;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return url_string;
    }
    private boolean isDigit(char c){
        switch(c){
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
    private String select_count_chats(String data){

        int a = data.indexOf("messages") + "messages".length()+1;
        StringBuilder count = new StringBuilder();
        while(isDigit(data.charAt(a+1))){
            count.append(data.charAt(a+1));
            a += 1;
        }
        if (count.length() == 0)
            count.append('0');
        return count.toString();
    }

    public  String count_unseen_chats(){
        this.url_req =  "https://api.vk.com/method/account.getCounters?&access_token="
                + token_notifications + "&v=5.131";
        String VK_data = get_VK_data(url_req);
        return select_count_chats(VK_data);
    }

}
