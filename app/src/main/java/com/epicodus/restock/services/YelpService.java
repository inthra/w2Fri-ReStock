package com.epicodus.restock.services;

import android.util.Log;

import com.epicodus.restock.Constants;
import com.epicodus.restock.models.Foodtruck;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class YelpService {
    public static void findFoodcarts(String location, Callback callback) {
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.YELP_CONSUMER_KEY, Constants.YELP_CONSUMER_SECRET);
        consumer.setTokenWithSecret(Constants.YELP_TOKEN, Constants.YELP_TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);

        String url = urlBuilder.build().toString();

        Request request= new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Foodtruck> processResults(Response response) {
        ArrayList<Foodtruck> foodcarts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject yelpJSON = new JSONObject(jsonData);
                JSONArray businessesJSON = yelpJSON.getJSONArray("businesses");

                for (int i = 0; i < businessesJSON.length(); i++) {
                    JSONObject foodcartJSON = businessesJSON.getJSONObject(i);
                    String name = foodcartJSON.getString("name");
                    String phone = foodcartJSON.optString("display_phone", "Phone not available");
                    double latitude = foodcartJSON.getJSONObject("location").getJSONObject("coordinate").getDouble("latitude");
                    double longitude = foodcartJSON.getJSONObject("location").getJSONObject("coordinate").getDouble("longitude");
                    ArrayList<String> address = new ArrayList<>();
                    JSONArray addressJSON = foodcartJSON.getJSONObject("location").getJSONArray("display_address");

                    for (int y = 0; y < addressJSON.length(); y++) {
                        address.add(addressJSON.get(y).toString());
                    }

                    Foodtruck restaurant = new Foodtruck(name, phone, address, latitude, longitude);
                    foodcarts.add(restaurant);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return foodcarts;
    }
}
