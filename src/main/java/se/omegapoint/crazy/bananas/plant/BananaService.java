package se.omegapoint.crazy.bananas.plant;

/**
 * Created by piolin on 13/05/16.
 */

import se.omegapoint.crazy.bananas.JsonTransformer;
import se.omegapoint.crazy.bananas.source.WaterClient;
import se.omegapoint.crazy.bananas.sun.SunClient;
import spark.Spark;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class BananaService {

    private static final SunClient sunClient = new SunClient();
    private static final WaterClient waterClient = new WaterClient();

    public static void main(String[] args) {
        port(Integer.parseInt(System.getProperty("port", "4444")));
        staticFileLocation("/public");
        Spark.get("/banana", (req, res) -> getBanana(), new JsonTransformer());
    }

    private static Object getBanana() {
        return new Banana(waterClient.dropOfWater(), sunClient.sunShine());
    }

}
