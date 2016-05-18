package se.omegapoint.crazy.bananas;

/**
 * Created by piolin on 18/05/16.
 */
public class Banana {
    private final String color;

    public Banana(String water, String sun) {
        if ("water!".equals(water) && "sun!".equals(sun)) {
            this.color = "yellow";
        } else {
            this.color = "brown";
        }
    }

    public Banana() {
        this.color = "torskblock";
    }
}
