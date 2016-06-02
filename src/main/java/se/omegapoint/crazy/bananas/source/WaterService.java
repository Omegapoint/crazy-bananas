package se.omegapoint.crazy.bananas.source;

import se.omegapoint.crazy.bananas.JsonTransformer;
import se.omegapoint.crazy.bananas.delay.SleepClient;
import se.omegapoint.crazy.bananas.secret.SecretClient;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by piolin on 13/05/16.
 */
public class WaterService {

    private static final SecretClient client = new SecretClient();
    private static final SleepClient sleeper = new SleepClient();


    public static void main(String[] args) {
        int port = Integer.parseInt(System.getProperty("port", "3333"));
        port(port);
        get("/water", (req, res) -> getDropOfWater(port),
                new JsonTransformer());
    }

    private static DropOfWater getDropOfWater(int port) {
        sleeper.sleep(port);
        return new DropOfWater(client.secret().secret());
    }

}
