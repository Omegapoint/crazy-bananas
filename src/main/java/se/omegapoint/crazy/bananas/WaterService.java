package se.omegapoint.crazy.bananas;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by piolin on 13/05/16.
 */
public class WaterService {
    public static void main(String[] args) {
        port(1723);
        get("/water", (req, res) -> "water!");
    }

}
