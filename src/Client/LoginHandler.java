package Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class LoginHandler {

    /* Takes a user string and pass string and makes a post request to the server */

    private static HttpURLConnection connection;

    public LoginHandler(String user, String pass){
        String urlString = "http://localhost:3000/login";
        String params = "user=%s&pass=%s".formatted(user, pass);
        byte[] postData = params.getBytes(StandardCharsets.UTF_8);
        try {
            var url = new URL(null, urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Java client");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            try(var wr = new DataOutputStream(connection.getOutputStream())){
                wr.write(postData);
            }
            StringBuilder content;
            try(var br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String line;
                content = new StringBuilder();
                while((line = br.readLine()) != null){
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());
        } catch (MalformedURLException e) {
            System.out.println("Incorrect URL");
        } catch (IOException e){
            System.out.println("Could not open URL connection");
        }
    }
}
