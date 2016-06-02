package se.omegapoint.crazy.bananas.sun;

/**
 * Created by piolin on 13/05/16.
 */

import se.omegapoint.crazy.bananas.JsonTransformer;
import se.omegapoint.crazy.bananas.delay.SleepClient;
import se.omegapoint.crazy.bananas.secret.SecretClient;
import spark.Spark;

import static spark.Spark.port;

public class SunService {

    private static final SecretClient client = new SecretClient();
    private static final SleepClient sleeper = new SleepClient();


    public static void main(String[] args) {
        int port = Integer.parseInt(System.getProperty("port", "2222"));
        port(port);
        Spark.get("/sun", (req, res) -> getSunRay(port),
                new JsonTransformer());
    }

    private static SunRay getSunRay(int port) {
        sleeper.sleep(port);
        return new SunRay(client.secret().secret());
    }

}
