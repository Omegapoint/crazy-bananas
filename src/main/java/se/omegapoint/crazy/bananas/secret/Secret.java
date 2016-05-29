package se.omegapoint.crazy.bananas.secret;

import java.util.UUID;

/**
 * Created by piolin on 23/05/16.
 */
public class Secret {
    private final String secret;

    public Secret() {
        this.secret = UUID.randomUUID().toString();
    }

    public String secret() {
        return secret;
    }
}
