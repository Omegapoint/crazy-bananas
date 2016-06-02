package se.omegapoint.crazy.bananas.secret;

import se.omegapoint.crazy.bananas.JsonTransformer;
import se.omegapoint.crazy.bananas.delay.SleepClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by piolin on 23/05/16.
 */
public class SecretService {

    private static AtomicReference<Secret> cached = new AtomicReference<>(new Secret());
    private static final SleepClient sleeper = new SleepClient();

    public static void main(String[] args) {
        int port = Integer.parseInt(System.getProperty("port", "1111"));
        port(port);
        get("/secret", (req, res) -> getSecret(port), new JsonTransformer());
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> updateSecret(), 5, 5, TimeUnit.SECONDS);
    }

    private static Secret getSecret(int port) {
        sleeper.sleep(port);
        return cached.get();
    }

    private static void updateSecret() {
        cached.set(new Secret());
    }
}
