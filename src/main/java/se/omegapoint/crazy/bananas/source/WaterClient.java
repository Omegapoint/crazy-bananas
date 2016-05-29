package se.omegapoint.crazy.bananas.source;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by piolin on 28/05/16.
 */
public class WaterClient {

    private final Gson gson = new Gson();
    private final static java.net.URI URI = java.net.URI.create("http://localhost:3333/water");

    public DropOfWater dropOfWater() {

        try {
            URLConnection connection = URI.toURL().openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            return gson.fromJson(IOUtils.toString(stream, Charset.defaultCharset()), DropOfWater.class);
        }
        catch (IOException e) {
            System.out.println("Totally unexpected when fetching some water: " + e);
        }
        return null;
    }
}
