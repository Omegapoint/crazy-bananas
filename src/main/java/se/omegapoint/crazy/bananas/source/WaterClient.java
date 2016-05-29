package se.omegapoint.crazy.bananas.source;

import com.google.gson.Gson;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by piolin on 28/05/16.
 */
public class WaterClient {

    private final static java.net.URI URI = java.net.URI.create("http://localhost:3333/water");


    public DropOfWater dropOfWater() {
        return new GetWaterCommand().execute();
    }

    private static class GetWaterCommand extends HystrixCommand<DropOfWater> {

        private final Gson gson = new Gson();

        protected GetWaterCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("Water"), 1000);
        }

        @Override
        protected DropOfWater run() throws Exception {
            URLConnection connection = URI.toURL().openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            return gson.fromJson(IOUtils.toString(stream, Charset.defaultCharset()), DropOfWater.class);
        }

        @Override
        protected DropOfWater getFallback() {
            return new DropOfWater("secret");
        }
    }
}

