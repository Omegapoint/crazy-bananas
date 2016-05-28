package se.omegapoint.crazy.bananas.sun;

/**
 * Created by piolin on 13/05/16.
 */

import se.omegapoint.crazy.bananas.JsonTransformer;
import se.omegapoint.crazy.bananas.secret.SecretClient;
import spark.Spark;

import static spark.Spark.port;

public class SunService {

    private static final SecretClient client = new SecretClient();

    public static void main(String[] args) {
        port(2222);
        Spark.get("/sun", (req, res) -> new SunRay(client.secret().secret()),
                new JsonTransformer());
    }

}
