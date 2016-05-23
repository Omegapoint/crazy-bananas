package se.omegapoint.crazy.bananas.secret;

import java.util.UUID;

/**
 * Created by piolin on 23/05/16.
 */
public class Secret {
    private final static long LIFE_SPAN_MILLIS = 3000;
    private final String secret;
    private final long timestamp;

    public Secret() {
        this.secret = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

    public String secret() {
        return secret;
    }

    public boolean hasExpired() {
        return timestamp + LIFE_SPAN_MILLIS < System.currentTimeMillis();
    }
}
