package se.omegapoint.crazy.bananas.delay;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.*;

/**
 * Created by piolin on 31/05/16.
 */
public class SleepAsAService {

    private final static Map<String, Integer> sleeps = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        port(Integer.parseInt(System.getProperty("port", "5555")));
        get("sleep/:port", (req, res) -> sleep(req.params(":port")));
        put("/sleep/:port", (req, res) -> setSleep(req.params(":port"), req.queryParams("time")));
    }

    private static int sleep(String port) {
        int sleepTime = Optional.ofNullable(sleeps.get(port)).orElse(0);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sleepTime;
    }

    private static int setSleep(String port, String time) {
        int value = Integer.parseInt(time);
        sleeps.put(port, value);
        return value;
    }
}
