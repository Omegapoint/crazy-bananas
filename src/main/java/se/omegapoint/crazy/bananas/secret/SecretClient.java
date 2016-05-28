package se.omegapoint.crazy.bananas.secret;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by piolin on 23/05/16.
 */
public class SecretClient {

    private final Gson gson = new Gson();
    private final static URI URI = java.net.URI.create("http://localhost:1111/secret");

    public final Secret secret() {

        try {
            URLConnection connection = URI.toURL().openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            return gson.fromJson(IOUtils.toString(stream, Charset.defaultCharset()), Secret.class);
        }
        catch (IOException e) {
            System.out.println("Totally expected error when trying to fetch a secret: " + e);
        }
        return new Secret();
    }

}
