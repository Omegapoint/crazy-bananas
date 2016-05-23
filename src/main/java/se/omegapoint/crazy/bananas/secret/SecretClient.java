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

    public final Secret secret() {
        URI uri = URI.create("http://localhost:1111/secret");
        try {
            URLConnection connection = uri.toURL().openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            return gson.fromJson(IOUtils.toString(stream, Charset.defaultCharset()), Secret.class);
        }
        catch (IOException e) {
            System.out.println("Not expected here: " + e);
        }
        return new Secret();
    }

}
