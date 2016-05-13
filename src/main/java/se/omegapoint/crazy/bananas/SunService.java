package se.omegapoint.crazy.bananas;

/**
 * Created by piolin on 13/05/16.
 */

import static spark.Spark.get;
import static spark.Spark.port;

public class SunService {
    public static void main(String[] args) {
        port(1337);
        get("/sun", (req, res) -> "sun!");
    }


}
