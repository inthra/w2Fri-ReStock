package com.epicodus.restock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodcart;
import com.epicodus.restock.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DeliveryActivity extends AppCompatActivity {
    public static final String TAG = DeliveryActivity.class.getSimpleName();

    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Foodcart> mFoodcarts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        ButterKnife.bind(this);

        String location = "portland";

        getFoodcarts(location);
    }

    private void getFoodcarts(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findFoodcarts(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mFoodcarts = yelpService.processResults(response);

                DeliveryActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] restaurantNames = new String[mFoodcarts.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[i] = mFoodcarts.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(DeliveryActivity.this,
                                android.R.layout.simple_list_item_1, restaurantNames);
                        mListView.setAdapter(adapter);

                        for (Foodcart foodcart : mFoodcarts) {
                            Log.d(TAG, "Name: " + foodcart.getName());
                            Log.d(TAG, "Phone: " + foodcart.getPhone());
                            Log.d(TAG, "Website: " + foodcart.getWebsite());
                            Log.d(TAG, "Address: " + android.text.TextUtils.join(", ", foodcart.getAddress()));
                        }
                    }
                });
            }
        });
    }
}
