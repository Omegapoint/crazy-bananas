package se.omegapoint.crazy.bananas.secret;

import se.omegapoint.crazy.bananas.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by piolin on 23/05/16.
 */
public class SecretService {

    // TODO pisu: thread-safe me!
    private static Secret cached = new Secret();

    public static void main(String[] args) {
        port(1111);
        get("/secret", (req, res) -> secret(), new JsonTransformer());
    }

    private static Secret secret() {
        if (cached.hasExpired()) {
            cached = new Secret();
        }
        return cached;
    }
}
