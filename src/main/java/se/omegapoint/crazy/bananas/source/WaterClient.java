package se.omegapoint.crazy.bananas.source;

import com.google.gson.Gson;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import org.apache.commons.io.IOUtils;
import rx.Observable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by piolin on 28/05/16.
 */
public class WaterClient {

    private final static String PATH = "/water";

    private final Gson gson = new Gson();
    private final BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
            .buildFixedServerListLoadBalancer(Arrays.asList(new Server("http://localhost", 3333), new Server("http://localhost", 3334)));


    public DropOfWater dropOfWater() {
        LoadBalancerCommand<DropOfWater> command = LoadBalancerCommand.<DropOfWater>builder().withLoadBalancer(loadBalancer).build();
        return command.submit(server -> {
            try {
                URLConnection connection = URI.create(server.getHostPort() + PATH).toURL().openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                return Observable.just(gson.fromJson(IOUtils.toString(stream, Charset.defaultCharset()), DropOfWater.class));
            } catch (IOException e) {
                System.out.println("Totally unexpected when fetching some water: " + e);
            }
            return null;
        }).toBlocking().first();
    }
}
