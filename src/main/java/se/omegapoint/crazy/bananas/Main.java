package se.omegapoint.crazy.bananas;

/**
 * Created by piolin on 13/05/16.
 */

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
