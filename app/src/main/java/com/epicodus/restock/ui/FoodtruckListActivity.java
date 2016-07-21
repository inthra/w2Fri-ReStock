package com.epicodus.restock.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.restock.Constants;
import com.epicodus.restock.R;
import com.epicodus.restock.adapters.FoodtruckListAdapter;
import com.epicodus.restock.models.Foodtruck;
import com.epicodus.restock.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FoodtruckListActivity extends AppCompatActivity {
    public static final String TAG = FoodtruckListActivity.class.getSimpleName();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private FoodtruckListAdapter mAdapter;

    public ArrayList<Foodtruck> mFoodcarts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodtruck);
        ButterKnife.bind(this);

        getFoodcarts(Constants.LOCATION_FIX);
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

                FoodtruckListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new FoodtruckListAdapter(getApplicationContext(), mFoodcarts);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FoodtruckListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
