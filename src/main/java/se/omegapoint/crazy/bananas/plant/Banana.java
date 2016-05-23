package se.omegapoint.crazy.bananas.plant;

import se.omegapoint.crazy.bananas.source.DropOfWater;
import se.omegapoint.crazy.bananas.sun.SunRay;

/**
 * Created by piolin on 18/05/16.
 */
public class Banana {
    private final String color;

    public Banana(DropOfWater water, SunRay sun) {
        if (water.secret().equals(sun.secret())) {
            this.color = "yellow";
        } else {
            this.color = "brown";
        }
    }

    public Banana() {
        this.color = "torskblock";
    }
}
