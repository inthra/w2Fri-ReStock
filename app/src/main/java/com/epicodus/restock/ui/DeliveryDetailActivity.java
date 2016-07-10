package com.epicodus.restock.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.restock.R;
import com.epicodus.restock.adapters.FoodcartPagerAdapter;
import com.epicodus.restock.models.Foodcart;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DeliveryDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private FoodcartPagerAdapter adapterViewPager;
    ArrayList<Foodcart> mFoodcarts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_detail);
        ButterKnife.bind(this);

        mFoodcarts = Parcels.unwrap(getIntent().getParcelableExtra("foodcarts"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));

        adapterViewPager = new FoodcartPagerAdapter(getSupportFragmentManager(), mFoodcarts);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
