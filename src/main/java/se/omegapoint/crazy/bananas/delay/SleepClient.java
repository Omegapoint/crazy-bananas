package se.omegapoint.crazy.bananas.delay;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by piolin on 02/06/16.
 */
public class SleepClient {

    private final static String baseUrl = "http://localhost:5555/sleep";

    public final int sleep(int port) {
        try {
            URI uri = URI.create(baseUrl + "/" + port);
            URLConnection connection = uri.toURL().openConnection();
            connection.connect();
            return Integer.parseInt(IOUtils.toString(connection.getInputStream(), Charset.forName("UTF-8")));
        } catch (IOException e) {
            // if there's something wrong with the service, just don't sleep.
        }
        return 0;
    }
}
