package com.epicodus.restock.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.restock.Constants;
import com.epicodus.restock.R;
import com.epicodus.restock.adapters.FoodtruckPagerAdapter;
import com.epicodus.restock.models.Foodtruck;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodtruckDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private FoodtruckPagerAdapter adapterViewPager;
    ArrayList<Foodtruck> mFoodcarts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodtruck_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("back to food truck list");

        mFoodcarts = Parcels.unwrap(getIntent().getParcelableExtra(Constants.PARCEL_FOODTRUCKS));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        adapterViewPager = new FoodtruckPagerAdapter(getSupportFragmentManager(), mFoodcarts);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
