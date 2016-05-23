package se.omegapoint.crazy.bananas.secret;

import se.omegapoint.crazy.bananas.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by piolin on 23/05/16.
 */
public class SecretService {

    public static void main(String[] args) {
        port(1111);
        get("/secret", (req, res) -> new Secret(), new JsonTransformer());
    }
}
