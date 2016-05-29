package se.omegapoint.crazy.bananas.source;

import se.omegapoint.crazy.bananas.JsonTransformer;
import se.omegapoint.crazy.bananas.secret.SecretClient;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by piolin on 13/05/16.
 */
public class WaterService {

    private static final SecretClient client = new SecretClient();
    private static final int port = Integer.parseInt(System.getProperty("port", "3333"));

    public static void main(String[] args) {
        port(port);
        get("/water", (req, res) -> getDropOfWater(),
                new JsonTransformer());
    }

    private static DropOfWater getDropOfWater() {
        System.out.println("Returning a drop of water. My port is: " + port);
        return new DropOfWater(client.secret().secret());
    }

}
