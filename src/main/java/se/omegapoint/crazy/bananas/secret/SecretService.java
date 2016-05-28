package se.omegapoint.crazy.bananas.secret;

import se.omegapoint.crazy.bananas.JsonTransformer;

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

    // TODO pisu: thread-safe me!
    private static AtomicReference<Secret> cached = new AtomicReference<>(new Secret());

    public static void main(String[] args) {
        port(1111);
        get("/secret", (req, res) -> cached.get(), new JsonTransformer());
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> updateSecret(), 5, 5, TimeUnit.SECONDS);
    }

    private static void updateSecret() {
        cached.set(new Secret());
    }
}
