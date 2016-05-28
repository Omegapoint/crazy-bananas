package se.omegapoint.crazy.bananas.sun;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by piolin on 27/05/16.
 */
public class SunClient {

    private final Gson gson = new Gson();
    private final static URI URI = java.net.URI.create("http://localhost:2222/sun");

    public SunRay sunShine() {

        try {
            URLConnection connection = URI.toURL().openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            return gson.fromJson(IOUtils.toString(stream, Charset.defaultCharset()), SunRay.class);
        }
        catch (IOException e) {
            System.out.println("Totally unexpected when getting some sun: " + e);
        }
        return null;
    }
}
