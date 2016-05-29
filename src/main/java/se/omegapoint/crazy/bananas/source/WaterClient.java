package se.omegapoint.crazy.bananas.source;

import com.google.gson.Gson;
import com.netflix.ribbon.ClientOptions;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.http.HttpRequestTemplate;
import com.netflix.ribbon.http.HttpResourceGroup;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

/**
 * Created by piolin on 28/05/16.
 */
public class WaterClient {

    private final Gson gson = new Gson();
    private final static HttpResourceGroup waterResource = Ribbon.createHttpResourceGroup("waterResource",
            ClientOptions.create().withConfigurationBasedServerList("http://localhost:3333, http://localhost:3334").withMaxAutoRetriesNextServer(2));
    private final static HttpRequestTemplate<ByteBuf> request = waterResource.newTemplateBuilder("getWater").withMethod("GET").withUriTemplate("/water").build();


    public DropOfWater dropOfWater() {
        ByteBuf byteBuf = request.requestBuilder().build().execute();
        return gson.fromJson(byteBuf.toString(Charset.forName("UTF-8")), DropOfWater.class);
    }
}
