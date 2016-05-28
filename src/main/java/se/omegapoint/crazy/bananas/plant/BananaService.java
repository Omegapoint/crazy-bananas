package se.omegapoint.crazy.bananas.plant;

/**
 * Created by piolin on 13/05/16.
 */

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import se.omegapoint.crazy.bananas.JsonTransformer;
import se.omegapoint.crazy.bananas.source.DropOfWater;
import se.omegapoint.crazy.bananas.sun.SunClient;
import spark.Spark;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;

import static spark.Spark.staticFileLocation;

public class BananaService {

    private static final Gson gson = new Gson();
    private static final SunClient sunClient = new SunClient();

    public static void main(String[] args) {

        staticFileLocation("/public");
        Spark.get("/banana", (req, res) -> getBanana(), new JsonTransformer());
    }

    private static Object getBanana() {
        URI waterUri = URI.create("http://localhost:1723/water");

        try {
            String water = getResource(waterUri);

            return new Banana(gson.fromJson(water, DropOfWater.class), sunClient.sunShine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Banana();
    }

    private static String getResource(URI uri) throws IOException {
        URLConnection connection = uri.toURL().openConnection();
        connection.connect();
        InputStream stream = connection.getInputStream();
        return IOUtils.toString(stream, Charset.defaultCharset());
    }
}
