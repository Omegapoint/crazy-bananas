package se.omegapoint.crazy.bananas.sun;

/**
 * Created by piolin on 13/05/16.
 */

import se.omegapoint.crazy.bananas.JsonTransformer;
import spark.Spark;

import static spark.Spark.port;

public class SunService {
    public static void main(String[] args) {
        port(1337);
        Spark.get("/sun", (req, res) -> new SunRay("secret"),
                new JsonTransformer());
    }


}
