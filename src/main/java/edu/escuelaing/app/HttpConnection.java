package edu.escuelaing.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class HttpConnection {

    private static final String userAgent = "Mozilla/5.0";
    private static String urlGetUrl = "http://www.omdbapi.com/?t=";
    private static final String urlApiKey = "&apikey=1d29ad7c";

    private static final HashMap<String, String> cache = new HashMap<>();

    public static String movieTitle(String title) throws IOException {
        if (cache.containsKey(title)) {
            System.out.println("Cache used");
            return cache.get(title);
        }

        String urlComplete = urlGetUrl + title + urlApiKey;
        URL obj = new URL(urlComplete);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", userAgent);
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String res = "[" + response.toString() + "]";
            cache.put(title, res);
            return res;
        } else {
            System.out.println("GET request not worked");
        }
        return "Failed";
    }
}
