package se.omegapoint.crazy.bananas;

/**
 * Created by piolin on 13/05/16.
 */

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;

import static spark.Spark.get;

public class BananaService {
    public static void main(String[] args) {

        get("/banana", (req, res) -> getBanana());
    }

    private static String getBanana() {
        URI uri = URI.create("http://localhost:1723/water");
        try {
            URLConnection connection = uri.toURL().openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            String water = IOUtils.toString(stream, Charset.defaultCharset());

            if ("water!".equals(water)) {
                return "banana!";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "no banana!";
    }
}
