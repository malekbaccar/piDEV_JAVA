package tn.esprit.indusmarket.indusmarketback.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.indusmarket.indusmarketback.Entities.GeocodeResult;

import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class GeocodeController {
    @RequestMapping(path = "/geocode", method = RequestMethod.GET )
    public GeocodeResult getGeocode(@RequestParam String address) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String encodedAddress = URLEncoder.encode(address, "UTF-8");
        Request request = new Request.Builder()
                .url("https://google-maps-geocoding.p.rapidapi.com/geocode/json?address="+address)
                .get()
                .addHeader("X-RapidAPI-Key", "caf83ab54amsh7c09f9cfec15ca6p15df8djsnb130792f6d31")
                .addHeader("X-RapidAPI-Host", "google-maps-geocoding.p.rapidapi.com")
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();
        GeocodeResult result = objectMapper.readValue(responseBody.string(), GeocodeResult.class);
        return result;
    }
}